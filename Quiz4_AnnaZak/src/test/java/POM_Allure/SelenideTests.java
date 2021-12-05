package POM_Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.FileDownloadMode.HTTPGET;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTests {

    public SelenideTests(){
        startMaximized=true;
        holdBrowserOpen=false;
        baseUrl = "https://demoqa.com/";
        reopenBrowserOnFail = true;

        screenshots=true;
        Configuration.fileDownload = HTTPGET;
        reportsFolder="C:\\Users\\Admin\\Desktop\\TestAutomationProject\\screenshots";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));



    }

    @Test
    @Flaky
    public void clickForm(){
        open("https://demoqa.com/");
        $(".card mt-4 top-card").find("div").findAll("h5").get(1).shouldHave(text("Forms")).click();

    }
    @Test
    public void clickPracticeForm() {
        open("https://demoqa.com/forms");
        $(".element-list collapse show").findAll("span").get(1).shouldHave(text("Practice Form")).click();
        sleep(5000);
    }
    @Test
    public void isImage() {
        open("https://demoqa.com/books");
        $(".rt-td img").isImage();
        sleep(5000);
    }

    @Test
    public void waitForElement() {
        open("/dynamic_loading/1");
        $(byText("Start")).click();

        //$("#finish h4").shouldHave(text("Hell World"));
        Assert.assertEquals( $("#finish h4").getText(),"Hell World");

        // $("#finish h4").waitUntil(visible,10000).getText();

    }

    @Test(description = "Add and Remove Elements",enabled=false)
    @Description("Additional description")
    public void doAction(){
        open("/add_remove_elements/");
        // $(byText("Delete")).click();
        for (int i = 0; i <3 ; i++) {
            $(byText("Add Element")).click();
        }
        $$(byText("Delete")).shouldHave(texts("Delete","Delete","Add"));
        $(byText("Delete")).click();
        //  System.out.println($("body").find("#elements").findAll(".added-manually").get(0).getText());
        sleep(4000);
    }
    @Test(enabled=false)
    public void fillInputs(){
        $(byAttribute("type","number")).setValue("1");
        $(byAttribute("type","number")).shouldHave(value("5"));
        sleep(4000);
    }
    @Test
    public void handleCheckbox(){
        open("/checkboxes");
        // $$("#checkboxes input").stream().forEach(el -> { el.shouldHave(type("checkbox"));});
        //Assert.assertEquals($("#checkboxes input").isDisplayed(),true);
        Assert.assertTrue($("#checkboxes input").isDisplayed());
        $("#checkboxes input").shouldBe(Condition.appear);
        sleep(4000);
    }
    @Test(enabled=false)
    public void handleDropDowns(){
        open("/dropdown");
        $("#dropdown").getSelectedOption().shouldHave(matchText("Option 1"),value("1"));
        $("#dropdown").selectOptionContainingText("Option 1");
        $("#dropdown").getSelectedOption().shouldHave(matchText("ption 1"),value("1"));
    }

    @AfterClass
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }
}
