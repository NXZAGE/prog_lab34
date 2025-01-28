package places;

import abstractions.Place;

public final class UncertainPlace extends Place {
    public UncertainPlace() {
        super("uncertain place");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 29 + name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(this.hashCode() != obj.hashCode()) return false;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
