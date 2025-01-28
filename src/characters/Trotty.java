package characters;

import actions.PowerCarrieable;
import data.Gender;
import exceptions.NullPowerHolderCallException;
import polity.Demos;

public class Trotty extends Human implements PowerCarrieable {
    public Trotty() {
        super(
           "Тротти", Gender.FEMALE,
            utils.Random.getInt(0, 40),
            utils.Random.getInt(75,85),
            utils.Random.getInt(-80, -40), 
            utils.Random.getInt(-50,-10)
        );
    }

    public boolean isAcceptPower(Demos demos) {
        return true;
    }

    public void influencePolicy(Demos demos) {
        this.decreaseKindnessIndex(15);
        this.decreaseHealthIndex(10);
        this.decreaseHonestyIndex(50);
        this.decreaseHappynessIndex(10);
        try {
            demos.updateTrustIndex();
        } catch (NullPowerHolderCallException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
