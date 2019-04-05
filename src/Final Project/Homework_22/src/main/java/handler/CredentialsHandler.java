package handler;

import model.Credentials;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class CredentialsHandler {
    private List<Credentials> creds = new ArrayList<>();
    private Credentials credentials;
    boolean bEmail = false;
    boolean bPassword = false;


    public List<Credentials> getCredentials() {
        return creds;
    }


    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("Credentials")) {
            credentials = new Credentials();
            if (credentials == null) {
                creds = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("email")) {
            bEmail = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        }
    }


    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Credentials")) {
            creds.add(credentials);
        }
    }


    public void characters(char ch[], int start, int length) throws SAXException {

        if (bEmail) {
            credentials.setEmail(new String(ch, start, length));
            bEmail = false;
        } else if (bPassword) {
            credentials.setPassword(new String(ch, start, length));
            bPassword = false;
        }
    }
}


