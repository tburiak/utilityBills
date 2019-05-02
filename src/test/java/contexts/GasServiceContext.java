package contexts;

import com.codeborne.selenide.SelenideElement;
import core.BaseContext;

public class GasServiceContext extends BaseContext {

    private static final String URL = "https://104.ua/ua/";

    private SelenideElement
            buttonSignIn = getControl("//a[normalize-space(.)='Увійти']"),
            inputUserName = getControl("//input[@id='username']"),
            inputPassword = getControl("//input[@id='password']"),
            buttonEntry = getControl("//input[@class='entry']");

    public static String getUrl() {
        return URL;
    }

    public GasServiceContext clickButtonSignIn() {
        buttonSignIn.click();
        return this;
    }

    public GasServiceContext setUserName(String userName) {
        inputUserName.setValue(userName);
        return this;
    }

    public GasServiceContext setPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public GasServiceContext clickButtonEntry() {
        buttonEntry.click();
        return this;
    }


}
