package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationWithRandomUtilsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenter(genter)
                .setUserNumber(userNumber)
                .setBirthDay(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .checkFormAppears()
                .checkResultValue("Student Name", firstName + " " + lastName)
                .checkResultValue("Student Email", userEmail)
                .checkResultValue("Gender", genter)
                .checkResultValue("Mobile", userNumber)
                .checkResultValue("Date of Birth", day + month + year)
                .checkResultValue("Subjects", subjects)
                .checkResultValue("Hobbies", hobbies)
                .checkResultValue("Picture", picture)
                .checkResultValue("Address", address)
                .checkResultValue("State and City", state + " " + city);
    }

@Test
void successRegistrationRequiredFieldsTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setUserEmail(userEmail)
            .setGenter(genter)
            .setUserNumber(userNumber)
            .setBirthDay(day, month, year)
            .setHobbies(hobbies)
            .setAddress(address)
            .submit()
            .checkFormAppears()
            .checkResultValue("Student Name", firstName + " " + lastName)
            .checkResultValue("Student Email", userEmail)
            .checkResultValue("Gender", genter)
            .checkResultValue("Mobile", userNumber)
            .checkResultValue("Date of Birth", day + month + year)
            .checkResultValue("Hobbies", hobbies)
            .checkResultValue("Address", address);
}

@Test
void unsuccessfulRegistrationWithoutRequiredFieldsTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(firstName)
            .setLastName(lastName)
            .submit()
            .checkFormNotAppears();
}
}

