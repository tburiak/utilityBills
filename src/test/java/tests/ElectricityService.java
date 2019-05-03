package tests;

import com.codeborne.selenide.Selenide;
import contexts.ElectricityServiceContext;
import core.BaseService;
import org.testng.annotations.Test;

public class ElectricityService extends BaseService {
    @Test
    public void addCounterValues_Topol(){
        String counterValue = getProp().getProperty("electricity.Topol");
        Selenide
                .open(ElectricityServiceContext.getUrl(), ElectricityServiceContext.class)
                .setUserName("tarasb855")
                .setPassword("integrator87")
                .clickButtonEntry()
                .clickButtonAddValues()
                .setCounterValueWithCondition(counterValue)
                .verifyConsumptionResultIsCorrect(true)
//                .clickButtonAddValues()
                .logOut();
    }
    @Test
    public void addCounterValues_Panikahi(){
        String counterValue = getProp().getProperty("electricity.Panikahi");

        Selenide
                .open(ElectricityServiceContext.getUrl(), ElectricityServiceContext.class)
                .setUserName("ludmilab855")
                .setPassword("integrator87")
                .clickButtonEntry()
                .clickButtonAddValues()
                .setCounterValueWithCondition(counterValue)
                .verifyConsumptionResultIsCorrect(true)
                //                .clickButtonAddValues()
                .logOut();

    }
}
