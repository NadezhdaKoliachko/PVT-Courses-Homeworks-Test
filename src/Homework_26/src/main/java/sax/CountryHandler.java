package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Country;

public class CountryHandler extends DefaultHandler {
    private List<Country> countries = new ArrayList<>();
    private Country country;
    boolean bCode = false;
    boolean bName = false;
    boolean bDescription = false;

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("Country")) {
            String id = attributes.getValue("id");
            country = new Country();
            country.setId(Integer.parseInt(id));
            if (country == null) {
                countries = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("code")) {
            bCode = true;
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("description")) {
            bDescription = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Country")) {
            countries.add(country);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bCode) {
            country.setCode(new String(ch, start, length));
            bCode = false;
        } else if (bName) {
            country.setName(new String(ch, start, length));
            bName = false;
        } else if (bDescription) {
            country.setDescription(new String(ch, start, length));
            bDescription = false;
        }
    }
}
