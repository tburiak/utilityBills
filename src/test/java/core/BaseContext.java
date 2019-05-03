package core;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BaseContext {

    protected SelenideElement getControl(String xpath){
        return $x(xpath);
    }

}
