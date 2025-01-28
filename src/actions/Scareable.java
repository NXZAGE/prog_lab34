package actions;

public interface Scareable {
    public static final int MIN_SADNESS = 1;
    public static final int MAX_SADNESS = 4;

    // target loses happyhess with some X
    public void scare(String reason);
}
