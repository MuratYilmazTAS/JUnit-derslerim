package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P12_KeyboardActions extends TestBase {

    @Test
    public void AmazonArama() {

        driver.get("https://www.amazon.com");
        //amazonda Iphone XR aramasi yapalim

        Actions actions=new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox)

                .keyUp(Keys.SHIFT).sendKeys("i").keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("hone").keyDown(Keys.SHIFT).sendKeys("XR").sendKeys(Keys.ENTER).perform();
        WebElement sonucKelimesi = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));
        String expectedWords = "iPhone XR";
        String actualWords = sonucKelimesi.getText();
        Assert.assertTrue(actualWords.contains(expectedWords));


    }
}
