package polity;

import actions.PowerCarrieable;
import actions.PrisonResponsible;
import exceptions.NullPowerHolderCallException;

public class Demos implements PrisonResponsible {
    private Power power;
    private Integer trustIndex;

    public Demos() {
        this.power = new Power();
    }

    public Demos(PowerCarrieable powerHolder) throws RuntimeException {
        this.power = new Power(powerHolder);
        try {
            this.updateTrustIndex();
        } catch (NullPowerHolderCallException exception) {
            throw new RuntimeException(exception.getMessage()); // ахахаххахахахахаха
        }
    }

    public void givePower(PowerCarrieable target) {
        if (this.power.owner() != null && this.power.isAccepted()) {
            String message = this.power.owner().toString() + " уже является правителем";
            System.out.println(message);
            return;
        }

        this.power.setOwner(target);
        String message = "Ожидается принятие власти от " + target.toString();
        System.out.println(message);
        this.checkPowerConfirmation();
    }

    public void takeAwayPower() {
        if (this.power.owner() == null) {
            String message = "Никто не наделен властью";
            System.out.println(message);
            return;
        }

        String message = this.power.owner().toString() + " лишен власти";
        this.power.resetOwner();
        System.out.println(message);
    }

    public void updateTrustIndex() throws NullPowerHolderCallException {
        if (this.power.owner() == null || this.power.isAccepted() == false) {
            throw new NullPowerHolderCallException("No power holder");
        }

        this.trustIndex = this.power.owner().getHonestyIndex(); 
        if (this.trustIndex < 20) this.tryOverthrow(); 
    }

    private void tryOverthrow() {
        int delta = Math.abs(-50 - this.trustIndex);
        double addProbability = (1.0 / 70.0) * delta;
        double probability = addProbability + Math.random();
        double successProbability = 1.0;
        double EPS = 1e-6;
        if (probability - successProbability > EPS) {
            this.takeAwayPower();
        }
    }

    private void checkPowerConfirmation() {
        if (this.power.isAccepted()) {
            String message = "Правитель уже коронован";
            System.out.println(message);
            return;
        }

        String message;
        if (this.power.owner().isAcceptPower(this)) {
            this.power.confirmNewOwner();
            message = String.format(
                "Правитель %s был коронован", this.power.owner()
            );
            System.out.println(message);
            this.power.owner().influencePolicy(this);
            return;
        }
        message = String.format(
            "%s отверг власть. Народ в поисках кандидата.", this.power.owner()
        );
        this.power.resetOwner();
        System.out.println(message);
    }

    public Integer getTrustIndex() {
        return this.trustIndex;
    }

    public boolean isNoPowerHolder() {
        return this.power.isAccepted() == false;
    }

    @Override
    public String toString() {
        return "Народ государства X";
    }
}
