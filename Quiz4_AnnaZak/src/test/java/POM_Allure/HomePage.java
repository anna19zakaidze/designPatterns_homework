package POM_Allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends BaseTest {

    By LoginBtn = By.id("login");

    @Step
    public void clickLogin() {
        driver.findElement(LoginBtn).click();
    }
}
