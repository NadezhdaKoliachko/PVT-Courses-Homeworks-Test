package runner;

import handler.CredentialsHandler;
import model.Credentials;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import parser.DomParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static Runner instance;

    private Runner() throws SQLException {
    }

    public static Runner getInstance() throws SQLException { // #3
        if (instance == null) {        //если объект еще не создан
            instance = new Runner();    //создать новый объект
        }
        return instance;        // вернуть ранее созданный объект
    }

    private static final String LOGINCREDENTIALS_XML = "logincredentials.xml";

    public ArrayList<CharSequence> parseXML() throws ParserConfigurationException, IOException, SAXException {

        ArrayList<CharSequence> loginPassword = new ArrayList<>();
        CredentialsHandler credentialsHandler = new CredentialsHandler();
        List<Credentials> creds = credentialsHandler.getCredentials();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(LOGINCREDENTIALS_XML);
        creds = new DomParser().parse(document);
        CharSequence email = "";
        CharSequence password = "";
        for (Credentials credentials : creds) {
            email = credentials.getEmail();
            password = credentials.getPassword();
        }
        loginPassword.add(email);
        loginPassword.add(password);
        return loginPassword;
    }

}

