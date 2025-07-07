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
        $("#genterWrapper").$(byText("Other")).click();
        $("#dateOfBirthInput").setValue(birthday);

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".btn-primary").click();
        $(".table-responsive").shouldHave(text(nameUser),text(lastNameUser),text(mail));
        sleep(3000);

    }
}
