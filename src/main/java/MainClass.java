import ModelDictionary.Dictionary;
import Factory.DictionaryCreationFactory;

public class MainClass {
    public static void main(String[] args) {
        Dictionary test = DictionaryCreationFactory.getInstance().getDictionary(false);
        /*for(int i = 0; i < test.getWords().size(); i++){
            System.out.println(test.getWords().get(i).getNativeWord());
            System.out.println(test.getWords().get(i).getTranscription());
            System.out.println(test.getWords().get(i).getTranslation());
            System.out.println();
        }*/
        System.out.println(test.getUser().getID());
        System.out.println(test.getUser().getFirstName());
        System.out.println(test.getUser().getSurname());
        System.out.println(test.getUser().getLogin());
        System.out.println(test.getUser().getPassword());
    }
}
