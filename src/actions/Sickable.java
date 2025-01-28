package actions;

public interface Sickable {
    public enum Disease {
        PLAGUE,
        COLD,
        WEAKNESS
    }
    public void getSick(Disease disease);
}
