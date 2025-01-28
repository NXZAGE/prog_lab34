package actions;

public interface Speakable {
    public void sayTo(Speakable partners, String phrase);
    public void say(String phrase);
}
