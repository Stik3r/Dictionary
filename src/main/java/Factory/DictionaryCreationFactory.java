package Factory;

import ModelDictionary.Dictionary;


public class DictionaryCreationFactory {
    public static final DictionaryCreationFactory instance = new DictionaryCreationFactory();

    private DictionaryCreationFactory(){}

    public static DictionaryCreationFactory getInstance() {
        return instance;
    }

    public Dictionary getDictionary(boolean typeCreate) { //Метод для получения готового словаря, логическая переменная
        if(typeCreate){                                   //отвечает за метод создания если истина то рандомная генерация
            return new Generator().DictionaryGenerate();  //если лож то чтение из файла
        } else {
            return new XMLParser().ParseDictionary();
        }
    }
}
