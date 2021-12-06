package POM_Allure;

import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@Listeners({ SoftAsserts.class})
public class RegistrationForm extends BaseTest {
    By practiceFormsBtn = (By)  $(".element-list collapse show").findAll("span").get(1).shouldHave(text("Practice Form"));
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By gender = By.id("gender-radio-2");
    By mobile = By.id("userNumber");
    By submitBtn = By.id("submit");
    WebElement successRegistrationForm = driver.findElement(By.id("example-modal-sizes-title-lg"));

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
    @Step("Check success registration")
    public void checkSuccessRegistration() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(successRegistrationForm.getText(),"Thanks for submitting the form");
        softAssert.assertAll();
    }
}
