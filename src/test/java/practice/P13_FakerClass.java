package practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P13_FakerClass extends TestBase {

    @Test
    public void faker() throws InterruptedException {
        driver.get("https://www.automationexercise.com/");
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement mailKutusu = driver.findElement(By.xpath("(//input[@name='email'])[2]"));

        Faker faker = new Faker();
        String isim=faker.name().fullName();
        String email=faker.internet().emailAddress();
        Actions actions = new Actions(driver);
        actions.click(isimKutusu).sendKeys(isim).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("id_gender1")).click();
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        actions.click(isimKutusu).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber()).perform();

        driver.findElement(By.xpath("(//button[@type='submit'])[1]"));


    }
}
