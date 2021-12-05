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
    @Test(description = "Login and Logout Scenario")
    @Description("Success login and logout scenario")
    @Story("Valid username and password login test")

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


    }

    //Register another student and use TestNG @DataProvider to keep test data and avoid test duplication
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Anna","Zakaidze","599264447"}, {"Nino","Zakaidze","123123123"}};
    }
    @Flaky
    @Test(description = "Login and Logout Scenario",dataProvider = "data-provider")
    @Description("Success login and logout scenario")
    @Story("Valid username and password login test")

    public void RegisterAnother(){

        FormPages formPages = new FormPages();
        RegistrationForm registrationForm = new RegistrationForm();

        //Click on 'Forms'
        formPages.clickFormPages();

        //Click on 'Practice Form'
        registrationForm.clickRegistrationForm();

        //Fill First Name, Last Name , Gender and mobile number
        registrationForm.registerUser("Anna","Zakaidze","599264447");
        registrationForm.clickRegistration();


    }

    @Flaky
    @Test(description = "Login and Logout Scenario")
    @Description("Success login and logout scenario")
    //  @Story("InvaliValid username and password login test")
    public void invalidLogin(){

        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        Dashboard dashboard = new Dashboard();
        home.clickLogin();
        login.enterUsername("alina23");
        login.enterPassword("Automation");
        login.clickLogin();
        dashboard.checkText();
        dashboard.clickLogout();

    }

}
