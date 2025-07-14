package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class demoqaPageObjects extends TestBase {


    @Test
    void successfulSearchTest() {

        String nameUser = "Andrew";
        String lastNameUser = "Bonita";
        String mail = "andrew.bonita@mail.ru";
        //String birthday = "12.12.1997";
        String phoneNumber = "89999999999";
        String currentAddress = "bububu";

        registrationPage.openPage()
                .setFirstName(nameUser)
                .setLastName()
                .setEmail(mail)
                .setNumber(phoneNumber)
                .setGender("Other")
                .setBirthday("30", "July", "1997");
        //$("#gender-radio-1").parent().click()//good method
        //$("#dateOfBirthInput").setValue(birthday);
        //Работа с Select and Option Выпадашка
        $(".btn-primary").click();

        registrationPage.verifyResultModalAppears()
                        .verifyResult("Student Name", nameUser + lastNameUser)
                        .verifyResult("Student Email", mail)
                        .verifyResult("Mobile", phoneNumber)
                        .verifyResult("Gender", "Other")
                        .verifyResult("Date of Birth", "30 July,2025");

        sleep(3000);

    }
    /*
    // Используем в том случае, если у нас в доп файле метод не выозвращает this
    @Test
    void successfulSearchTest1() {

        String nameUser = "Andrew";
        String lastNameUser = "Bonita";
        String mail = "andrew.bonita@mail.ru";
        //String birthday = "12.12.1997";
        String phoneNumber = "89999999999";
        String currentAddress = "bububu";

        registrationPage.openPage();

        registrationPage.setFirstName(nameUser);
        registrationPage.setLastName();
        registrationPage.setEmail(mail);
        registrationPage.setNumber(phoneNumber);
        registrationPage.setGender("Other");
        //$("#gender-radio-1").parent().click()//good method
        //$("#dateOfBirthInput").setValue(birthday);
        //Работа с Select and Option Выпадашка
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();



        $(".btn-primary").click();
        $(".table-responsive").shouldHave(text(nameUser),text(lastNameUser),text(mail));
        sleep(3000);

    }

     */
}


