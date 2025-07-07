package demoQa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class demoqa {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulSearchTest() {

        String nameUser = "Andrew";
        String lastNameUser = "Bonita";
        String mail = "andrew.bonita@mail.ru";
        String birthday = "12.12.1997";
        String phoneNumber = "89999999999";
        String currentAddress = "bububu";

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
