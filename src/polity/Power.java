package polity;

import actions.PowerCarrieable;

public class Power {
    private PowerCarrieable owner;
    private boolean accepted;

    public Power() {
        this.owner = null;
        this.accepted = false;
    }

    public Power(PowerCarrieable owner) {
        this.owner = owner;
        this.accepted = true;
    }

    public boolean isAccepted() { return this.accepted; }

    public PowerCarrieable owner() { return this.owner; }

    public void setOwner(PowerCarrieable owner) {
        this.owner = owner;
        this.accepted = false;
    }

    public void resetOwner() {
        this.owner = null;
        this.accepted = false;
    }

    public void confirmNewOwner() {
        if (this.accepted) {
            String message = "Уже дейсвтует полноправный правитель.";
            System.out.println(message);
            return;
        }

        if (this.owner == null) {
            String message = "Отсутствует кондидат";
            System.out.println(message);
            return;
        }

        this.accepted = true;
    }
}
