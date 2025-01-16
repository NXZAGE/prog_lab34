package characters;

import actions.PowerCarrieable;
import data.Gender;
import polity.Power;

public class April extends Human implements PowerCarrieable {
    public April() {
        super("Эйприл", Gender.FEMALE);
    }

    public void acceptPower(Power power) {
        System.out.println("Приняла силу");
    }

    public void losePower(Power power) {
        System.out.println("Потеряла силу");
    }
}