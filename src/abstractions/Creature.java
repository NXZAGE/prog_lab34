package abstractions;

public abstract class Creature {
    protected boolean isAlive;

    public Creature() {
        isAlive = true;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public abstract void die();
    public abstract String getInfo();
}
