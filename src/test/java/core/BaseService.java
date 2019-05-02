package core;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;

public class BaseService {

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().version("74.0.3729.6");
        Configuration.holdBrowserOpen = true;
    }
}
