package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    static Faker faker = new Faker();

    public static String getRandomFirstName() {
        return faker.name().firstName();

    }

    public static String getRandomLastName() {
        return faker.name().lastName();

    }

    public static String getRandomUserEmail() {
        return faker.internet().safeEmailAddress();
    }

    public static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    // +3 (263) 253 - 66 - 12
    public static String getRandomNumberPhone() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomDateOfBirthDay() {

        Date fakerDateOfBirth = faker.date().birthday();
        SimpleDateFormat formatDay = new SimpleDateFormat("dd", Locale.ENGLISH);
        String day = formatDay.format(fakerDateOfBirth);

        return day;

    }

    public static String getRandomDateOfBirthMonth() {

        Date fakerDateOfBirth = faker.date().birthday();
        SimpleDateFormat formatMounth = new SimpleDateFormat("MMMMM", Locale.ENGLISH);
        String mouth = formatMounth.format(fakerDateOfBirth);

        return mouth;

    }

    public static String getRandomDateOfBirthYear() {

        Date fakerDateOfBirth = faker.date().birthday();
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        String year = formatYear.format(fakerDateOfBirth);

        return year;

    }

    public static String getRandomGenter() {
        String[] genter = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genter);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomSubjects() {
        String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies"};

        return getRandomItemFromArray(subjects);
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(state);
    }

    public static String getRandomCity(String state) {
        if (state.equals("NCR")) {

            String[] city = {"Delhi", "Gurgaon", "Noida"};

            return getRandomItemFromArray(city);
        }
        if (state.equals("Uttar Pradesh")) {

            String[] city = {"Agra", "Lucknow", "Merrut"};

            return getRandomItemFromArray(city);
        }
        if (state.equals("Haryana")) {

            String[] city = {"Karnal", "Panipat"};

            return getRandomItemFromArray(city);
        }
        else {

            String[] city = {"Jaipur", "Jaiselmer"};

            return getRandomItemFromArray(city);
        }
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

}
