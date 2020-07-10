package ModelDictionary;

public class Word {
    private long id;
    private String nativeWord;
    private String translation;
    private String transcription;
    static long idIter = 0;

    public Word(String nativeWord, String translation, String transcription){
        id = idIter;
        idIter++;
        this.nativeWord = nativeWord;
        this.translation = translation;
        this.transcription = transcription;
    }

    public long getId() {
        return id;
    }

    public String getNativeWord() {
        return nativeWord;
    }

    public String getTranscription() {
        return transcription;
    }

    public String getTranslation() {
        return translation;
    }

    public void setNativeWord(String nativeWord) {
        this.nativeWord = nativeWord;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }
}
