package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P11_Iframe extends TestBase {

    @Test
    public void IframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement sayfadakiYazi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sayfadakiYazi.isDisplayed());
        System.out.println(sayfadakiYazi.getText());

        // iframe olan sayfaya iframe icindeki herhangi bir seyi test edebilmek icin
        // once iframe cercevesine girmek(gecmek) gerekir.

        WebElement iframeCercevesi = driver.findElement(By.id("mce_0_ifr"));// iframe cercevesine gecis yapiyoruz
        driver.switchTo().frame(iframeCercevesi);

        WebElement iframeYazisi = driver.findElement(By.id("tinymce"));
        String iframedekiYazi=iframeYazisi.getText();
        System.out.println(iframedekiYazi);
        iframeYazisi.clear();
        iframeYazisi.sendKeys("have a wise day");
    }
}
