package abstractions;

public abstract class Creature {
    private Boolean isAlive;

    public Creature() {
        isAlive = true;
    }

    public void die() {
        this.isAlive = false;
    }

    public Boolean isAlive() {
        return this.isAlive;
    }
}
