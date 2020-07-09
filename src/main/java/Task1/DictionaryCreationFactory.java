package Task1;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;

public class DictionaryCreationFactory {
    public static final DictionaryCreationFactory instance = new DictionaryCreationFactory();

    private DictionaryCreationFactory(){}

    public static DictionaryCreationFactory getInstance() {
        return instance;
    }

    public Dictionary getDictionary(boolean typeCreate) {
        if (typeCreate) {
            return new Dictionary().generate();
        } else {
            DocumentBuilder bilder = null;
            try {
                LanguageType languageType = LanguageType.DEUTSH;
                ArrayList<Word> words = new ArrayList<Word>();
                String[] userInfo = new String[4];
                bilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = bilder.parse("DictionaryXML.xml");
                Node root = document.getDocumentElement();
                NodeList info = root.getChildNodes();
                for (int i = 0; i < info.getLength(); i++) {
                    if (info.item(i).getNodeName() == "user") {
                        NodeList userInfoXML = info.item(i).getChildNodes();
                        for (int j = 0; j < userInfo.length; j++) {
                            userInfo[j] = userInfoXML.item(j).getNodeValue();
                        }
                    } else if (info.item(i).getNodeName() == "language") {
                        languageType = LanguageType.valueOf(info.item(i).getNodeValue());
                    } else {
                        String[] wordInfo = new String[3];
                        NodeList wordInfoXML = info.item(i).getChildNodes();
                        for (int j = 0; j < wordInfo.length; j++) {
                            wordInfo[j] = wordInfoXML.item(j).getNodeValue();
                        }
                        words.add(new Word(wordInfo[0], wordInfo[1], wordInfo[2]));
                    }
                }
                User user = new User(userInfo[0],userInfo[1],userInfo[2],userInfo[3]);
                if(languageType != null) {
                    return new Dictionary(user, languageType, words);
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
