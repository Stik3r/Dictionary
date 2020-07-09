package Task1;

public class Word {
    private long id;
    private String nativeWord;
    private String translation;
    private String transcription;
    static long idIter = 0;

    public Word(String _nativeWord, String _translation, String _transcription){
        id = idIter;
        idIter++;
        setNativeWord(_transcription);
        translation = _translation;
        transcription = _transcription;
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
}
