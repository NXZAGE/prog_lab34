package actions;
import polity.Demos;

public interface PowerCarrieable {
    public boolean isAcceptPower(Demos requester);
    public void influencePolicy(Demos evaluater);
    public int getHonestyIndex();
}
