package ModelDictionary;

import java.util.List;

public class Dictionary {
    private Long id;
    private User user;
    private LanguageType languageType;
    private List<Word> words;
    private static Long idIter = (long)0;

    public Dictionary(User user, LanguageType languageType, List<Word> words){
        id = idIter;
        idIter++;
        this.user = user;
        this.languageType = languageType;
        this.words = words;
    }

    public User getUser() {
        return user;
    }

    public List<Word> getWords() {
        return words;
    }

}
