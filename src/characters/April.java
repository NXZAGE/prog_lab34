package characters;

import actions.PowerCarrieable;
import data.Gender;
import exceptions.NullPowerHolderCallException;
import polity.Demos;

public class April extends Human implements PowerCarrieable {
    public April() {
        super(
            "Эйприл", Gender.FEMALE, 
            utils.Random.getInt(80, 90),
            utils.Random.getInt(88,97),
            utils.Random.getInt(85, 90), 
            utils.Random.getInt(-20,50)
        );
    }

    public boolean isAcceptPower(Demos demos) {
        boolean verdict = (
            (this.healthIndex > 85) && (this.happynessIndex > -50) ||
            (this.healthIndex > 80) && (this.happynessIndex > 20)
        );
        return verdict;
    }

    public void influencePolicy(Demos demos) {
        this.decreaseKindnessIndex(5);
        this.decreaseHealthIndex(10);
        this.increaseHonestyIndex(20);
        this.increaseHappynessIndex(10);
        try {
            demos.updateTrustIndex();
        } catch (NullPowerHolderCallException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void feelHeartPain(String reason) {
        int extraDamage = 4;
        int extraSadness = 4;
        super.feelHeartPain(reason);
        this.decreaseHappynessIndex(extraSadness);
        this.decreaseHealthIndex(extraDamage);
    }
}