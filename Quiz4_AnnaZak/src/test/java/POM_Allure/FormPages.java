package POM_Allure;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FormPages extends BaseTest{
    By formsBtn = (By) $(".card mt-4 top-card").find("div").findAll("h5").get(1).shouldHave(text("Forms"));

    @Step
    public void clickFormPages() {
        driver.findElement(formsBtn).click();
    }
}
