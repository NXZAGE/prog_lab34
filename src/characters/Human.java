package characters;

import java.util.ArrayList;

import abstractions.Creature;
import abstractions.Place;
import actions.HeartPainFeelable;
import actions.Movable;
import actions.PowerCarrieable;
import actions.PrisonResponsible;
import actions.Scareable;
import actions.Sickable;
import actions.Speakable;
import actions.VoiceCallable;
import records.Person;
import data.Gender;
import polity.Power;

public abstract class Human
        extends Creature
        implements VoiceCallable, HeartPainFeelable, Scareable, Sickable, Movable, PowerCarrieable, Speakable, PrisonResponsible {

    Person person;
    Place currentPlace;
    Integer honestyIndex;

    public Human(String name, Gender gender) {
        person = new Person(name, gender);
    }

    public void call(Human target) {
        System.out.println("Зовет");
    }

    public void feelHeartPain(String reason) {
        System.out.println("Страдает из-за " + reason);
    }

    public void scare(String reason) {
        System.out.println("Боится " + reason);
    }

    public void getSick(String diagnosis) {
        System.out.println("Заболел" + diagnosis);
    }   

    public void getWell() {
        System.out.println("Выздоровел");
    }

    public void Smove(Place place) {
        this.currentPlace = place;
    }

    public void acceptPower(Power power) {
        System.out.println("Принял(a) власть");
    }

    public void losePower(Power power) {
        System.out.println("Потерял(a) власть");
    }

    public void say(String phrase) {
        System.out.println(phrase);
    }

    public void sayTo(Speakable partner, String phrase) {
        System.out.println(phrase);
    }

    public void sayTo(ArrayList<Speakable> partnters, String phrase) {
        System.out.println(phrase);
    }

    public void changeHonestyIndex() {

    }

    public Integer getHonestyIndex() {
        return honestyIndex;
    }
}
