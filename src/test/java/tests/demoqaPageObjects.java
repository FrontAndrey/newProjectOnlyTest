package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomGender;
import static utils.RandomUtils.getRandomPhone;

public class demoqaPageObjects extends TestData {

    @Test
    void successfulSearchTest() {

        String phoneNumber = "8999999999";

        registrationPage.openPage()
                .setFirstName(nameUser)
                .setLastName(lastNameUser)
                .setEmail(mail)
                .setNumber(phoneNumber)
                .setGender(getRandomGender())
                .setBirthday("30", "July", "1997")
                .clickBtn()
                .verifyResultModalAppears()
                .verifyResult("Student Name", nameUser + " " + lastNameUser)
                .verifyResult("Student Email", mail)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Gender", getRandomGender())
                .verifyResult("Date of Birth", "30 July,1997");

        sleep(3000);

    }
}


