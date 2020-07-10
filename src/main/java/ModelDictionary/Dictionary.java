package ModelDictionary;

import java.util.List;

public class Dictionary {
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

    public User getUser() {
        return user;
    }

    public List<Word> getWords() {
        return words;
    }

}
