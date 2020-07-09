package Task1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary implements DictionaryGenerator {
    private Long id;
    private User user;
    private LanguageType languageType;
    private List<Word> words;
    private static Long idIter = (long)0;

    public Dictionary(User _user, LanguageType language, List<Word> _words){
        id = idIter;
        idIter++;
        user = _user;
        languageType = language;
        words = _words;
    }

    public Dictionary(){
        id = idIter;
        idIter++;
    }

    public User getUser() {
        return user;
    }

    public List<Word> getWords() {
        return words;
    }

    public Dictionary generate() {
        char[] symbol = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        String[] userInfo = new String[4];
        int iterCout = 0;
        Random random = new Random();

        while(iterCout < 4){ //*************************************************
            String someInfo = "";
            int length = 5 + random.nextInt(8);
            for(int i = 0; i < length; i++){
                someInfo += symbol[random.nextInt(symbol.length)]; //генерация юзера
            }
            userInfo[iterCout] = someInfo;
            iterCout++;//*******************************************************
        }

        int wordCount = 100 + random.nextInt(900);
        char[] symbolWord = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<Word> _words = new ArrayList<Word>(wordCount);
        int infoIter;
        ArrayList<String> wordInfo = new ArrayList<String>(3);

        for (int i = 0; i < wordCount; i++) {//**************************************************** Начало генерации слов
            infoIter = 0;
            wordInfo.clear();
            while (infoIter < 3) { //******************************************************* Начало генерации отдельного слова
                int length = 2 + random.nextInt(8);
                String someWordInfo = "";
                for (int j = 0; j < length; j++) {
                    someWordInfo += symbolWord[random.nextInt(symbolWord.length)];
                }
                wordInfo.add(infoIter, someWordInfo);
                infoIter++;
            }//************************************************************************** Конец генерации отдельного слова
            _words.add(new Word(wordInfo.get(0),wordInfo.get(1),wordInfo.get(2)));
        }//****************************************************************************************** Конец генерации слов


        languageType = LanguageType.values()[random.nextInt(1)];// Заполнение словаря данными
        user = new User(userInfo[0],userInfo[1],userInfo[2],userInfo[3]);
        words = _words;
        return this;
    }
}
