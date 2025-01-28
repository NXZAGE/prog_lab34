package characters;

import actions.PowerCarrieable;
import data.Gender;
import exceptions.NullPowerHolderCallException;
import polity.Demos;

public class TrottyMom extends Human implements PowerCarrieable {
    public TrottyMom() {
        super(
            "Мама Тротти", Gender.FEMALE,
            utils.Random.getInt(40, 60),
            utils.Random.getInt(40,65),
            utils.Random.getInt(-90, 0), 
            utils.Random.getInt(-40,10)
        );
    }

    public boolean isAcceptPower(Demos demos) {
        return true;
    }

    public void influencePolicy(Demos demos) {
        this.decreaseKindnessIndex(30);
        this.decreaseHealthIndex(56);
        this.decreaseHonestyIndex(70);
        this.increaseHappynessIndex(50);
        try {
            demos.updateTrustIndex();
        } catch (NullPowerHolderCallException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
