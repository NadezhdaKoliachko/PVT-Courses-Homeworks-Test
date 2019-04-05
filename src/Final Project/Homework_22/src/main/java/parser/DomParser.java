package parser;

import model.Credentials;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import java.util.ArrayList;
import java.util.List;

public class DomParser {
    public List<Credentials> parse(Document document) {
        NodeList nodeList = document.getElementsByTagName("Credentials");
        List<Credentials> creds = new ArrayList<Credentials>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            creds.add(getCredentials(nodeList.item(i)));
        }
        return creds;
    }

    private static Credentials getCredentials(Node node) {
        Credentials credentials = new Credentials();
        Element element = (Element) node;
        credentials.setEmail(getTagValue("email", element));
        credentials.setPassword(getTagValue("password", element));
        return credentials;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}


