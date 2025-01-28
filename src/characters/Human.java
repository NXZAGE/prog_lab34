package characters;

import abstractions.Creature;
import abstractions.Place;
import actions.HeartPainFeelable;
import actions.Movable;
import actions.PrisonResponsible;
import actions.Scareable;
import actions.Sickable;
import actions.Speakable;
import actions.VoiceCallable;
import records.Person;
import data.Gender;
import places.UncertainPlace;

public class Human
        extends Creature
        implements VoiceCallable, HeartPainFeelable, Scareable, Sickable, Movable, Speakable, PrisonResponsible { 
    
    protected Person person;
    protected Place currentPlace;
    protected int honestyIndex;
    protected int healthIndex;
    protected int kindnessIndex;
    protected int happynessIndex;
    protected static final int MAX_HONESTY_INDEX;
    protected static final int MIN_HONESTY_INDEX;
    protected static final int DEFAULT_HONESTY_INDEX;
    protected static final int MAX_HEALTH_INDEX;
    protected static final int MIN_HEALTH_INDEX;
    protected static final int DEFAULT_HEALTH_INDEX;
    protected static final int MAX_KINDNESS_INDEX;
    protected static final int MIN_KINDNESS_INDEX;
    protected static final int DEFAULT_KINDNESS_INDEX;
    protected static final int MIN_HAPPYNESS_INDEX;
    protected static final int MAX_HAPPYNESS_INDEX;
    protected static final int DEFAULT_HAPPYNESS_INDEX;

    static {
        MAX_HONESTY_INDEX = 100;
        MIN_HONESTY_INDEX = -100;
        DEFAULT_HONESTY_INDEX = 0;
        MAX_HEALTH_INDEX = 100;
        MIN_HEALTH_INDEX = 0;
        DEFAULT_HEALTH_INDEX = 100;
        MAX_KINDNESS_INDEX = 100;
        MIN_KINDNESS_INDEX = -100;
        DEFAULT_KINDNESS_INDEX = 0;
        MIN_HAPPYNESS_INDEX = -100;
        MAX_HAPPYNESS_INDEX = 100;
        DEFAULT_HAPPYNESS_INDEX = 0;
    }

    {
        this.honestyIndex = DEFAULT_HONESTY_INDEX;
        this.healthIndex = DEFAULT_HEALTH_INDEX;
        this.kindnessIndex = DEFAULT_KINDNESS_INDEX;
        this.happynessIndex = DEFAULT_HAPPYNESS_INDEX;
        this.currentPlace = new UncertainPlace();
    }

    public Human(String name, Gender gender) {
        person = new Person(name, gender);
    }

    public Human(String name, Gender gender, int honesty, int health, int kindeness, int happyness) {
        person = new Person(name, gender);
        this.honestyIndex = normalizedHonestyIndex(honesty);
        this.healthIndex = normalizedHealthIndex(health);
        this.kindnessIndex = normalizedKindnessIndex(kindeness);
        this.happynessIndex = normalizedHappynessIndex(happyness);
    }

    public int getHonestyIndex() { 
        return this.honestyIndex; 
    }

    public void increaseHonestyIndex(int value) {
        if (value < 0) {
            this.decreaseHonestyIndex(-value);
            return;
        }
        this.honestyIndex = Math.min(this.honestyIndex + value, MAX_HONESTY_INDEX);
    }

    public void decreaseHonestyIndex(int value) {
        if (value < 0) {
            this.increaseHonestyIndex(-value);
            return;
        }
        this.honestyIndex = Math.max(this.honestyIndex - value, MIN_HONESTY_INDEX);
    }   
   
    public static int normalizedHonestyIndex(int index) {
        if (index <= MIN_HONESTY_INDEX)
            return MIN_HONESTY_INDEX;    
        return Math.min(index, MAX_HONESTY_INDEX);
    }

    public int getHealthIndex() { 
        return this.healthIndex; 
    }

    public void increaseHealthIndex(int value) {
        if (this.isAlive == false) return;
        if (value < 0) {
            this.decreaseHealthIndex(-value);
            return;
        }
        this.healthIndex = Math.min(this.healthIndex + value, MAX_HEALTH_INDEX);
    }

    public void decreaseHealthIndex(int value) {
        if (this.isAlive == false) return;
        if (value < 0) {
            this.increaseHealthIndex(-value);
            return;
        }
        this.healthIndex = Math.max(this.healthIndex - value, MIN_HEALTH_INDEX);
        if (this.healthIndex == MIN_HEALTH_INDEX) {
            this.isAlive = false;
            String message = String.format("%s умер.", this.toString());
            System.out.println(message);
        }
    }   

    public static int normalizedHealthIndex(int index) {
        if (index <= MIN_HEALTH_INDEX)
            return MIN_HEALTH_INDEX;
        return Math.min(index, MAX_HEALTH_INDEX);
    }

    public int getKindnessIndex() { 
        return this.kindnessIndex; 
    }

    public void increaseKindnessIndex(int value) {
        if (value < 0) {
            this.decreaseKindnessIndex(-value);
            return;
        }
        this.kindnessIndex = Math.min(this.kindnessIndex + value, MAX_KINDNESS_INDEX);
    }

    public void decreaseKindnessIndex(int value) {
        if (value < 0) {
            this.increaseKindnessIndex(-value);
            return;
        }
        this.kindnessIndex = Math.max(this.kindnessIndex - value, MIN_KINDNESS_INDEX);
    }

    public static int normalizedKindnessIndex(int index) {
        if (index <= MIN_KINDNESS_INDEX)
            return MIN_KINDNESS_INDEX;
        return Math.min(index, MAX_KINDNESS_INDEX);
    }

    public int getHappynessIndex() { 
        return this.happynessIndex; 
    }

    public void increaseHappynessIndex(int value) {
        if (value < 0) {
            this.decreaseHappynessIndex(-value);
            return;
        }
        this.happynessIndex = Math.min(this.happynessIndex + value, MAX_HAPPYNESS_INDEX);
    }

    public void decreaseHappynessIndex(int value) {
        if (value < 0) {
            this.increaseHappynessIndex(-value);
            return;
        }
        this.happynessIndex = Math.max(this.happynessIndex - value, MIN_HAPPYNESS_INDEX);
    }

    public static int normalizedHappynessIndex(int index) {
        if (index <= MIN_HAPPYNESS_INDEX) 
            return MIN_HAPPYNESS_INDEX;
        return Math.min(index, MAX_HAPPYNESS_INDEX);
    }

    public void call(Human target) {
        if (Math.random() <= VoiceCallable.INCREASE_CHANCE) {
            target.increaseHappynessIndex(VoiceCallable.INCREASE_VALUE);
        }
        String message = String.format("%s зовет %s", this.toString(), target.toString());
        System.out.println(message);
    }

    public void feelHeartPain(String reason) {
        int minDamage = 0;
        int maxDamage = 4;
        int minSadness = 3;
        int maxSadness = 6;
        int lostHealth = utils.Random.getInt(minDamage, maxDamage);
        int lostHappyness = utils.Random.getInt(minSadness, maxSadness);
        this.decreaseHealthIndex(lostHealth);
        this.decreaseHappynessIndex(lostHappyness);
        String message = String.format(
            "%s страдает из-за \"%s\". -%d счастья. -%d здоровья.",
            this.toString(), reason, lostHappyness, lostHealth
        );
        System.out.println(message);
    }

    public void scare(String reason) {
        int minSadness = 1;
        int maxSadness = 6;
        int lostHappyness = utils.Random.getInt(minSadness, maxSadness);
        this.decreaseHappynessIndex(lostHappyness);
        String message = String.format(
            "%s боится %s. -%d счастья.",
            this.toString(), reason, lostHappyness
        );
        System.out.println(message);
    }

    public void getSick(Sickable.Disease disease) {
        int damage = switch (disease) {
            case Sickable.Disease.PLAGUE -> {
                int minDamage = 60;
                int maxDamage = 100;
                yield utils.Random.getInt(minDamage, maxDamage);
            }
            case Sickable.Disease.COLD -> {
                int minDamage = 5;
                int maxDamage = 20;
                yield utils.Random.getInt(minDamage, maxDamage);
            }
            case Sickable.Disease.WEAKNESS -> {
                int minDamage = 0;
                int maxDamage = 5;
                yield utils.Random.getInt(minDamage, maxDamage);
            }
            default -> {
                yield 0;
            }
        };

        String message = String.format(
            "%s заболел. Болезнь нанесла %d урона.",
            this.toString(), damage
        );
        System.out.println(message);
        this.decreaseHealthIndex(damage);
        if (this.isAlive) {
            message = this.toString() + " выздоровел";
            System.out.println(message);
        }
    }

    public void move(Place place) {
        this.currentPlace = place;
        String message = this.toString() + " переместился. Новое положение: " + place.toString();
        System.out.println(message);
    }

    public void say(String phrase) {
        String message = String.format(
            "%s говорит: \"%s\"", this.toString(), phrase  
        );
        System.out.println(message);
    }

    public void sayTo(Speakable partner, String phrase) {
        String message = String.format(
            "%s говорит %S: \"%s\"", this.toString(), partner.toString(), phrase  
        );
        System.out.println(message);
    }

    public void die() {
        this.decreaseHealthIndex((MAX_HEALTH_INDEX - MIN_HEALTH_INDEX) * 2);
    }

    public String getInfo() {
        String info = String.format(
            """
            ---INFO---------------------------------------------------------------
            == Имя: %s, Пол: %s
            == Жив: %s
            == Местоположение: %s
            =-- Здоровье: %d,
            =-- Честность: %d,
            =-- Счастье: %d,
            =-- Доброта: %d
            ----------------------------------------------------------------------
            """,
            person.name(), person.gender(),
            this.isAlive() ? "да" : "нет",
            this.currentPlace.toString(),
            this.healthIndex, this.honestyIndex, this.happynessIndex, this.happynessIndex
        );
        return info;
    }

    @Override
    public String toString() {
        return this.person.name();
    }

    @Override
    public int hashCode() {
        int statsHashCode = ((kindnessIndex * 31 + happynessIndex) * 37 + healthIndex * 47) + honestyIndex; 
        return ((super.hashCode() * 29 + person.hashCode()) * 53 + currentPlace.hashCode()) * 59 + statsHashCode;
    }   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.hashCode() != obj.hashCode()) return false;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Human human = (Human) obj;
        boolean result = (
            this.person.equals(human.person) &&
            this.currentPlace.equals(human.currentPlace) &&
            this.honestyIndex == human.honestyIndex &&
            this.kindnessIndex == human.kindnessIndex &&
            this.healthIndex == human.healthIndex &&
            this.happynessIndex == human.happynessIndex
        );
        return result;
    }
}
