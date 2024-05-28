package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Sign In")).click();
        String expectedWelcomeText = "Welcome Back!"; //expected Result
        String actualWelcomeText = driver.findElement(By.className("page__heading")).getText(); //Actual Result
        Assert.assertEquals("Invalid", expectedWelcomeText, actualWelcomeText); //Compare both Result
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user[email]")).sendKeys("yatri@gmail.com"); //Enter username
        driver.findElement(By.id("user[password]")).sendKeys("yatri"); //Enter password
        driver.findElement(By.className("button-primary")).click();
        String expectedErrorText = "Invalid email or password."; //expected Result
        String actualErrorText = driver.findElement(By.className("form-error__list-item")).getText(); //Actual Result
        Assert.assertEquals("Invalid credential", expectedErrorText, actualErrorText); //Compare both Result
    }


    @After
    public void tearDown() {
        //closeBrowser();
    }
}
