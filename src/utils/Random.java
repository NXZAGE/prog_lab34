package utils;

public class Random {
    public static int getInt(int min, int max) {
        return (int) Math.round(min + (max - min) * Math.random());
    }
}
