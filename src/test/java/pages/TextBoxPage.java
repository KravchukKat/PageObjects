package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress")
                    ;

    public TextBoxPage openPage(){

        open("/text-box");

        return this;
    }

    public TextBoxPage setUserName(String value){

        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmailName(String value){

        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value){

        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value){

        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage submit(){

        submit.click();

        return this;
    }

    public TextBoxPage checkNameResultValue(String value){

        outputName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkEmailResultValue(String value){

        outputEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkCurrentAddressResultValue(String value){

        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public TextBoxPage checkPermanentAddressResultValue(String value){

        outputPermanentAddress.shouldHave(text(value));

        return this;
    }
}