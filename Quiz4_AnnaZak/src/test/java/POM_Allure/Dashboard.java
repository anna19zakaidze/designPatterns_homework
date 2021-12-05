package POM_Allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Dashboard extends BaseTest {


    By heading = By.xpath("//div[@class=\"main-header\"]");
    By logoutBtn = By.id("submit");

    @Step
    public String getHeading() {
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        String head = driver.findElement(heading).getText();
        return head;
    }

    @Step
    public void checkText() {
        Assert.assertEquals(getHeading(),"Wrong");
    }

    @Step
    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
}
