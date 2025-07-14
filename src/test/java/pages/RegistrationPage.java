package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultModal registrationResultModal = new RegistrationResultModal();
    //переменные для элементов, которые могут повторяться
    private SelenideElement lastNameInput = $("#lastName"),
                            firsNameInput = $("#firstName"),
                            emailInput = $("#userEmail"),
                            numberInput = $("#userNumber"),
                            genderRadioButton = $("#genterWrapper"),
                            dateOFBirthdayInput = $("#dateOfBirthInput");
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    //Данные вводятся непосредственно в тесте
    public RegistrationPage setFirstName(String value) {
        firsNameInput.setValue(value);

        return this;
    }

    //Второй способ, когда данные зашиты в SetValue, плохой способ
    public RegistrationPage setLastName() {
        lastNameInput.setValue("value");

        return this;
    }
    //lastNameInput выводится в переменную, в случаях, когда он повторяется
    public RegistrationPage clearLastName() {
        lastNameInput.clear();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue((value));

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setBirthday(String day, String month, String year) {
        dateOFBirthdayInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    public RegistrationPage verifyResultModalAppears() {
        registrationResultModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);
        return this;
    }
}
