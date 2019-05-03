package core;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseService {

    private static Properties prop;

    protected static Properties getProp() {
        return prop;
    }

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().version("74.0.3729.6");
        Configuration.holdBrowserOpen = true;

        try {
            InputStream stream = this.getClass().getResourceAsStream("/counterValues.properties");
            prop = new Properties();
            prop.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
