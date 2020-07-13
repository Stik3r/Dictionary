package Factory;

import ModelDictionary.Dictionary;
import ModelDictionary.LanguageType;
import ModelDictionary.User;
import ModelDictionary.Word;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser{
    public Dictionary ParseDictionary(){ // парсер XMl документа использовался DOM
        try {
            //Получение документа и нахождение узлов
            //************************************************************************
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("DictionaryXML.xml");
            Node root = document.getDocumentElement();
            NodeList dictionary = root.getChildNodes();
            Node user = null;
            Node language = null;
            Node words = null;
            //************************************************************************

            //Проход по всем узлам документа и "запоминание" узлов для будущего использования
            //************************************************************************
            for(int i = 0; i < dictionary.getLength(); i ++){
                if(dictionary.item(i).getNodeType() != Node.TEXT_NODE){
                    switch (dictionary.item(i).getNodeName()){
                        case "user": user = dictionary.item(i);
                                break;

                        case "language":  language = dictionary.item(i);
                                        break;

                        case "words": words = dictionary.item(i);
                                    break;
                    }
                }
            }
            //**************************************************************************

            return new Dictionary(GetUser(user), GetLanguage(language), GetWords(words)); //возвращение словаря и вызов функций создания необходимых компонентов словаря
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User GetUser(Node root){   //метод извлечения информации о юзере из документа
        NodeList userInfoXML = root.getChildNodes();
        ArrayList<String> userInfo = new ArrayList<String>();
        for(int i = 0; i < userInfoXML.getLength(); i++){
            if(userInfoXML.item(i).getNodeType() != Node.TEXT_NODE){
                userInfo.add(userInfoXML.item(i).getFirstChild().getNodeValue());
            }
        }
        return new User(userInfo.get(0),userInfo.get(1),userInfo.get(2),userInfo.get(3));
    }

    private LanguageType GetLanguage(Node root){ // извлечение информации о языке
        return LanguageType.valueOf(root.getFirstChild().getNodeValue());
    }

    private List<Word> GetWords(Node root){ // метод который собирает в словарь все полученые слова из следующего метода
        ArrayList<Word> words = new ArrayList<Word>();
        NodeList wordsXML = root.getChildNodes();
        for(int i = 0; i < wordsXML.getLength(); i++){
            if(wordsXML.item(i).getNodeType() != Node.TEXT_NODE){
                words.add(GetWord(wordsXML.item(i)));
            }
        }
        return words;
    }

    private Word GetWord(Node root){ // извлечение слов
        ArrayList<String> wordInfo = new ArrayList<String>();
        NodeList wordInfoXML = root.getChildNodes();
        int count = 0;
        for(int i = 0; i < wordInfoXML.getLength(); i++){
            if(wordInfoXML.item(i).getNodeType() != Node.TEXT_NODE) {
                wordInfo.add(wordInfoXML.item(i).getFirstChild().getNodeValue());
            }
        }
        return new Word(wordInfo.get(0),wordInfo.get(1),wordInfo.get(2));
    }
}
