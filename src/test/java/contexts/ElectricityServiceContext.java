package contexts;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.BaseContext;
import org.testng.Assert;

public class ElectricityServiceContext extends BaseContext {

    private static final String URL = "https://ok.dnep.com.ua/home";

    private SelenideElement
            inputUserName = getControl("//input[@id='username']"),
            inputPassword = getControl("//input[@id='password']"),
            buttonEntry = getControl("//input[@type='submit']"),
            buttonAddValues = getControl("//a[normalize-space(.)='Занести показання']"),
            inputCurrentCounterValue = getControl("//input[@id='readings_counter_1']"),
            cellPreviousCounterValue = getControl("//b[contains(@class,'prev-readings') and @data-zone='1']"),
            cellConsumptionResult = getControl("//b[contains(@class,'consumption') and @data-zone='1']");


    public static String getUrl() {
        return URL;
    }

    public ElectricityServiceContext setUserName(String userName) {
        inputUserName.setValue(userName);
        return this;
    }

    public ElectricityServiceContext setPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public ElectricityServiceContext clickButtonEntry() {
        buttonEntry.click();
        return this;
    }

    private boolean validateCounterValue(String value) throws IllegalArgumentException{
        if (value.length() != 6) throw new IllegalArgumentException("Value has to equal 6th numbers.");
        else if(Integer.valueOf(value) < Integer.valueOf(cellPreviousCounterValue.getText()))
            throw new IllegalArgumentException("Current value has to be bigger than the value from the previous month.");
        return true;
    }

    private String adjustCounterValue(String value) {
        int limitedConsumption = 500;
        int previousValue = Integer.valueOf(cellPreviousCounterValue.getText());
        int currentValue = Integer.valueOf(value);
        if (currentValue - previousValue > limitedConsumption)
            value = String.valueOf(previousValue + limitedConsumption);
        return value;
    }

    private ElectricityServiceContext setCounterValue(String value) {
        inputCurrentCounterValue.setValue(value);
        return this;
    }

    public ElectricityServiceContext setCounterValueWithCondition(String value) {
        if (validateCounterValue(value)) value = adjustCounterValue(value);
        return setCounterValue(value);
    }

    public ElectricityServiceContext clickButtonAddValues() {
        buttonAddValues.click();
        return this;
    }

    public ElectricityServiceContext logOut() {
        Selenide.open("https://ok.dnep.com.ua/home/logout");
        return this;
    }

    public ElectricityServiceContext verifyConsumptionResultIsCorrect(boolean expected) {
        String actual = cellConsumptionResult.getText();
        Assert.assertEquals(Integer.valueOf(actual) <= 500, expected, "Monthly consumption: " + actual + " is bigger than 500 kWt/h");
        return this;
    }

}
