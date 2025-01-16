package actions;

import java.util.ArrayList;

public interface Speakable {
    public void sayTo(Speakable partners, String phrase);
    public void sayTo(ArrayList<Speakable> partners, String phrase);
    public void say(String phrase);
}
