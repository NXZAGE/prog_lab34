package polity;

import actions.PowerCarrieable;
import actions.PrisonResponsible;

public class Demos implements PrisonResponsible {
    private Power power;
    private Integer trustIndex;
    
    public void givePower(PowerCarrieable target) {
        
    }

    public void takeAwayPower(PowerCarrieable target) {

    }

    public void updateTrustIndex() {
        
    }

    public Integer getTrustIndex() {
        return this.trustIndex;
    }

    public Power power() {
        return this.power;
    }
}
