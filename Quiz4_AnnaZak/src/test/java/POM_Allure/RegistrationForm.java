package POM_Allure;

import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationForm extends BaseTest {
    By practiceFormsBtn = (By)  $(".element-list collapse show").findAll("span").get(1).shouldHave(text("Practice Form"));
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By gender = By.id("gender-radio-2");
    By mobile = By.id("userNumber");
    By submitBtn = By.id("submit");

    @Step("Go to registration form")
    public void clickRegistrationForm() {
        driver.findElement(practiceFormsBtn).click();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }

    @Step("Register user")
    public void registerUser(String fName, String lName,String mobilePhone) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(gender).click();
        driver.findElement(mobile).sendKeys(mobilePhone);
    }

    @Step("Click registration")
    public void clickRegistration() {

        driver.findElement(submitBtn).click();
    }
}
