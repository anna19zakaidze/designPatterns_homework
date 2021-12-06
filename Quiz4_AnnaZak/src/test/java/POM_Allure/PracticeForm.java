package POM_Allure;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Config.class)
@Epic("Regression Tests")
@Feature("Login Tests")
public class PracticeForm {
    @BeforeTest
    public void setup(){
        BaseTest baseTest=new BaseTest();
        baseTest.initialize();
        WebDriver driver= baseTest.getDriver();

        //Navigate to the https://demoqa.com/
        driver.get("https://demoqa.com/");

    }

    @Flaky
    @Test(description = "Register student Scenario")
    @Description("Success registration")

    public void Register(){

        FormPages formPages = new FormPages();
        RegistrationForm registrationForm = new RegistrationForm();

        //Click on 'Forms'
        formPages.clickFormPages();

        //Click on 'Practice Form'
        registrationForm.clickRegistrationForm();

        //Fill First Name, Last Name , Gender and mobile number
        registrationForm.registerUser("Nino","Zakaidze","123123123");
        registrationForm.clickRegistration();

        // Check that 'Thanks for submitting the form' text is visible

    }

    //Register another student and use TestNG @DataProvider to keep test data and avoid test duplication
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Anna","Zakaidze","599264447"}, {"Nino","Zakaidze","1232123123"}};
    }
    @Flaky
    @Test(description = "Login and Logout Scenario",dataProvider = "data-provider")
    @Description("Another student registration")

    public void RegisterAnother(){

        FormPages formPages = new FormPages();
        RegistrationForm registrationForm = new RegistrationForm();

        //Click on 'Forms'
        formPages.clickFormPages();

        //Click on 'Practice Form'
        registrationForm.clickRegistrationForm();

        //Fill First Name, Last Name , Gender and mobile number
        registrationForm.registerUser("Anna","Zakaidze","5992643447");
        registrationForm.clickRegistration();

        // Check that 'Thanks for submitting the form' text is visible
        registrationForm.checkSuccessRegistration();
    }


}
