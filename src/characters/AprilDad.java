package characters;

import actions.PowerCarrieable;
import data.Gender;
import exceptions.NullPowerHolderCallException;
import polity.Demos;

public class AprilDad extends Human implements PowerCarrieable {
    public AprilDad() {
        super(
            "Отец Эйприл", Gender.MALE,
            utils.Random.getInt(80, 90),
            utils.Random.getInt(40,85),
            utils.Random.getInt(20, 60), 
            utils.Random.getInt(-50,70)
        );
    }

    public boolean isAcceptPower(Demos demos) {
        return true;
    }

    public void influencePolicy(Demos demos) {
        this.increaseKindnessIndex(5);
        this.decreaseHealthIndex(30);
        this.decreaseHonestyIndex(10);
        this.decreaseHappynessIndex(5);
        try {
            demos.updateTrustIndex();
        } catch (NullPowerHolderCallException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
