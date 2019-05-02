package core;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BaseContext {

    protected SelenideElement getControl(String xpath){
        return $(byXpath(xpath));
    }

}
