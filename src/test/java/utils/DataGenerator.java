package utils;
import java.util.Random;

public class DataGenerator {
    public static String randomNumber() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }
    public static String randomEmail() {
        return "arabits.automation+" + randomNumber() + "@gmail.com";
    }
}
