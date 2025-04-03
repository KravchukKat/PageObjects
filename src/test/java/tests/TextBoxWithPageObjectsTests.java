package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Alex Egorov")
                .setEmailName("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()
                .checkNameResultValue("Alex Egorov")
                .checkEmailResultValue("alex@egorov.com")
                .checkCurrentAddressResultValue("Some street 1")
                .checkPermanentAddressResultValue("Another street 1");
    }
}