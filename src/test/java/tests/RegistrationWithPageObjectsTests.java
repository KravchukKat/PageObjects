package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                        .removeBanners()
                        .setFirstName("Alex")
                        .setLastName("Egorov")
                        .setUserEmail("alex@egorov.com")
                        .setGender("Other")
                        .setUserNumber("8922775126")
                        .setBirthDay("20", "January", "1990")
                        .setSubjects("Math")
                        .setHobbies("Sports")
                        .setPicture("cat.jpg")
                        .setAddress("Some street 1")
                        .setState("NCR")
                        .setCity("Noida")
                        .submit()
                        .checkFormAppears()
                        .checkResultValue("Student Name", "Alex Egorov")
                        .checkResultValue("Student Email", "alex@egorov.com")
                        .checkResultValue("Gender", "Other")
                        .checkResultValue("Mobile", "8922775126")
                        .checkResultValue("Date of Birth", "20 January,1990")
                        .checkResultValue("Subjects", "Math")
                        .checkResultValue("Hobbies", "Sports")
                        .checkResultValue("Picture", "cat.jpg")
                        .checkResultValue("Address", "Some street 1")
                        .checkResultValue("State and City", "NCR Noida");
    }

    @Test
    void successRegistrationRequiredFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Ekaterina")
                .setLastName("Ivanova")
                .setUserEmail("ivanova@mail.com")
                .setGender("Male")
                .setUserNumber("8123456789")
                .setBirthDay("08", "March", "2000")
                .setHobbies("Reading")
                .setAddress("Some street 2")
                .submit()
                .checkFormAppears()
                .checkResultValue("Student Name", "Ekaterina Ivanova")
                .checkResultValue("Student Email", "ivanova@mail.com")
                .checkResultValue("Gender", "Male")
                .checkResultValue("Mobile", "8123456789")
                .checkResultValue("Date of Birth", "8 March,2000")
                .checkResultValue("Hobbies", "Reading")
                .checkResultValue("Address", "Some street 2");
    }

    @Test
    void UnsuccessfulRegistrationWithoutRequiredFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("John")
                .setLastName("Snow")
                .submit()
                .checkFormNotAppears();
    }
}
