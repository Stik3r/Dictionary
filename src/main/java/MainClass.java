import Task1.Dictionary;
import Task1.DictionaryCreationFactory;
import Task1.Word;

public class MainClass {
    public static void main(String[] args) {
        Dictionary test = DictionaryCreationFactory.getInstance().getDictionary(false);
        for (Word word:
             test.getWords()) {
            System.out.println(word.getNativeWord());
            System.out.println(word.getTranscription());
            System.out.println(word.getTranslation());
            System.out.println();
        }
    }
}
