package actions;
import characters.Human;

public interface VoiceCallable {
    public static final double INCREASE_CHANCE = 0.35;
    public static final int INCREASE_VALUE = 3;
    
    // increases happynessIndex of target with chance
    public void call(Human target);
}
