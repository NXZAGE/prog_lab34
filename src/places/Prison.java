package places;
import java.util.ArrayList;

import abstractions.Place;
import actions.PrisonResponsible;
import characters.Human;

public class Prison extends Place {
    ArrayList<Human> prisoners;

    public Prison() {
        super("Тюрьма");
        prisoners = new ArrayList<Human>();
    }

    protected boolean isInPrison(Human human) {
        return prisoners.contains(human);
    }

    public void addPrisoner(Human prisoner, String reason, PrisonResponsible responsive) {
        if (this.isInPrison(prisoner)) {
            String message = prisoner.toString() + " уже находится в тюрьме";
            System.out.println(message);
            return;
        }

        prisoners.add(prisoner);
        prisoner.move(this);
        String message = prisoner.toString() + " попал в тюрьму.";
        message += "Причина: \"" + reason + "\".";
        message += "Ответсвенный: " + responsive.toString();
        System.out.println(message);  
    }

    public void releasePrisoner(Human prisoner, String reason, PrisonResponsible responsive) {
        if (this.isInPrison(prisoner) == false) {
            String message = prisoner.toString() + " не находится под стражей.";
            System.out.println(message);
            return;
        }

        prisoners.remove(prisoner);
        prisoner.move(new UncertainPlace());
        String message = prisoner.toString() + " был освобожден.";
        message += "Причина: \"" + reason + "\".";
        message += "Ответственный: " + responsive.toString();
        System.out.println(message);
    }

    public String getInfo() {
        String info = """
                ~~~~~~~~~~PRISON INFO~~~~~~~~~~
                Заключенные:
                """;
        for (int idx = 0; idx < prisoners.size(); ++idx) {
            info += String.format("%d. %s\n", idx + 1, prisoners.get(idx).toString());
        }

        if (prisoners.isEmpty()) {
            info += "none\n";
        }

        info += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

        return info;
    }

    @Override
    public String toString() {
        return "Тюрьма.";
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
        Prison prison = (Prison) obj;
        return this.prisoners.equals(prison.prisoners);
    }
}
