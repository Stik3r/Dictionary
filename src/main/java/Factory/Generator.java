package Factory;

import ModelDictionary.Dictionary;
import ModelDictionary.LanguageType;
import ModelDictionary.User;
import ModelDictionary.Word;

import java.util.*;

public class Generator implements DictionaryGenerator {

    @Override
    public Dictionary DictionaryGenerate() {
        return new Dictionary(UserGenerate(), LanguageGenerate(), WordsGenerate());
    }

    private User UserGenerate(){ // метод отвечаюзий за генерацию пользователя
        char[] symbol = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        String[] userInfo = new String[4];
        Random random = new Random();
        for(int i = 0; i < userInfo.length; i++){
            userInfo[i] = RandomString(symbol, 5 + random.nextInt(8));
        }
        return new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3]);
    }

    private LanguageType LanguageGenerate(){ // метод отвечающий за генерацию языка
        return LanguageType.values()[new Random().nextInt(1)];
    }


    private List<Word> WordsGenerate(){ // метод отвечающий за генерацию слов
        ArrayList<String> wordInfo = new ArrayList<String>();
        ArrayList<Word> words = new ArrayList<Word>();
        char[] symbol = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0; i < 100 + new Random().nextInt(100); i++){
                wordInfo.clear();
                for (int j = 0; j < 3; j++){
                    wordInfo.add(RandomString(symbol, 2 + new Random().nextInt(8)));
                }
                words.add(new Word(wordInfo.get(0),wordInfo.get(1),wordInfo.get(2)));
            }
        return words;
        }

    private String RandomString(char[] symbol, int symbolCount){ // метод который используется во всех остальных методах
        String result = "";                                      //он генерирует рандомные строки
        Random random = new Random();
        for (int i = 0; i < symbolCount; i++){
            result += symbol[random.nextInt(symbol.length)];
        }
        return result;
    }
}
