package tests;

import com.codeborne.selenide.Selenide;
import contexts.GasServiceContext;
import core.BaseService;
import org.testng.annotations.Test;

public class GasService extends BaseService {

    @Test
    public void addCounterValues(){

        Selenide
                .open(GasServiceContext.getUrl(), GasServiceContext.class)
                .clickButtonSignIn()
                .setUserName("taras")
                .setPassword("123456")
                .clickButtonEntry();

    }
}
