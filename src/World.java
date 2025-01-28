import actions.Sickable;
import characters.*;
import places.*;
import polity.Demos;

public final class World {
    April april;
    AprilDad aprilDad;
    Krispin krispin;
    Trotty trotty;
    TrottyMom trottyMom;
    Demos demos;
    Prison prison;
    TrottyXMomHouse trottyXMomHouse;

    public World() {
        System.out.println("PREPARING");
        this.april = new April();
        this.aprilDad = new AprilDad();
        this.krispin = new Krispin();
        this.trotty = new Trotty();
        this.trottyMom = new TrottyMom();
        try {    
            this.demos = new Demos(aprilDad);
        } catch (RuntimeException exception) {
            System.out.println("Я каюсь, я бездарность, я безнадежен, убейте меня, прошу (");
            System.exit(0);
        }
        this.prison = new Prison();
        this.trottyXMomHouse = new TrottyXMomHouse();
        this.prison.addPrisoner(april, "unknown", this.trottyMom);
        System.out.println("PREPARING ENDED");
    }
    
    public void run() {
        System.out.println(april.getInfo());
        System.out.println(aprilDad.getInfo());
        System.out.println(trotty.getInfo());
        System.out.println(trottyMom.getInfo());
        System.out.println(krispin.getInfo());
        april.call(krispin);
        april.scare("Trotty and her mom might kill the bird");
        april.sayTo(trottyMom, "Did u kill the bird");
        if (trottyMom.getKindnessIndex() < 40) {
            System.out.println("Эйприл не получает ответа");
            april.feelHeartPain("Trotty and her mom might kill the bird and keeps silence");
        }
        System.out.println(april.getInfo());
        aprilDad.getSick(Sickable.Disease.PLAGUE);
        System.out.println(aprilDad.getInfo());
        if (aprilDad.isAlive()) {
            prison.releasePrisoner(april, "King will", aprilDad);
            System.out.println(april.getInfo());
            System.out.println("--END OF STORY-- Король живой, неканон, но все довольны счастливы всем пока");
            return;
        }
        demos.takeAwayPower();
        demos.givePower(trottyMom);
        System.out.println(trottyMom.getInfo());
        if (trottyMom.isAlive()) {
            System.out.println("--END OF STORY-- Полная жестб они устроили тоталитаризм и все загрустили, анлак");
            return;
        }
        demos.takeAwayPower(); // она умерла ((
        if (utils.Random.getInt(0, 1) == 0) {
            // у тротти не получилось сбежать и ее посадили
            prison.addPrisoner(trotty, "danger for society", demos);
        } else {
            trotty.move(trottyXMomHouse);
        }
        System.out.println(trotty.getInfo());
        System.out.println(prison.getInfo());
        prison.releasePrisoner(april, "No guilt", demos);
        demos.givePower(april);
        System.out.println(april.getInfo());
        if (demos.isNoPowerHolder()) {
            System.out.println("--END OF STORY-- Эйприл не согласилась стать королевой, вообще ниче не понятно ждем второй сезон");
        } else {
            System.out.println("--END OF STORY-- Эйприл корлева, канон, все классно");
        }
    }   
}
