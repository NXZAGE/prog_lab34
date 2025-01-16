package characters;

import actions.PowerCarrieable;
import data.Gender;
import polity.Power;

public class AprilDad extends Human implements PowerCarrieable {
    public AprilDad() {
        super("Отец Эйприл", Gender.MALE);   
    }

    public void acceptPower(Power power) {
        System.out.println("Принял власть");
    }

    public void losePower(Power power) {
        System.out.println("Потерял власть");
    }
}
