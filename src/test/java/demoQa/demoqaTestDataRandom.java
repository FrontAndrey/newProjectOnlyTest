package demoQa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class demoqaTestDataRandom {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulSearchTest() {
// захардкоженные значения
//        String nameUser = "Andrew",
//                lastNameUser = "Bonita",
//                mail = "andrew.bonita@mail.ru",
//                birthday = "12.12.1997",
//                phoneNumber = "89999999999",
//                currentAddress = "bububu";

//  Добавление библиотеки генерации рандомных значений
//        Faker faker = new Faker(new Locale("en-GB"));
//
//        String nameUser = faker.name().firstName(),
//                lastNameUser = faker.name().lastName(),
//                mail = faker.internet().emailAddress();

    String nameUser = getRandomString(10);
        String lastNameUser = getRandomString(10);
        String mail = getRandomEmail();
        String phoneNumber = getRandomPhone();

        open("/automation-practice-form");

        $("#firstName").setValue(nameUser);
        $("#lastName").setValue(lastNameUser);
        $("#userEmail").setValue(mail);
        $("#userNumber").setValue(phoneNumber);
        $("#gender-radio-1").parent().click(); //good method
        //$("#genterWrapper").$(byText("Other")).click();
        //$("#dateOfBirthInput").setValue(birthday);
        //Работа с Select and Option Выпадашка
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();


        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".btn-primary").click();
        $(".table-responsive").shouldHave(text(nameUser),text(lastNameUser),text(mail));
        sleep(3000);

    }
}
