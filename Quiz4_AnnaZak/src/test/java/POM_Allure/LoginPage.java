package POM_Allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest{
    By uName = By.id("userName");
    By pswd = By.id("password");
    By loginBtn = By.id("login");


    @Step("Login with userName {0}")
    public void enterUsername(String user) {
        driver.findElement(uName).sendKeys(user);

    }

    @Step("Login with password {0}")
    public void enterPassword(String pass) {

        driver.findElement(pswd).sendKeys(pass);
    }

    @Step
    public void clickLogin() {

        driver.findElement(loginBtn).click();
    }
}
