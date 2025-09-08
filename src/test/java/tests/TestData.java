package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

import static utils.RandomUtils.getRandomInt;


public class TestData {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    Faker faker = new Faker(new Locale("en-GB"));

        String nameUser = faker.name().firstName(),
                lastNameUser = faker.name().lastName(),
                mail = faker.internet().emailAddress();

}
