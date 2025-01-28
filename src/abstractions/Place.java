package abstractions;

public abstract class Place {
    protected String name;

    public Place(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + this.name.hashCode();
    }
}