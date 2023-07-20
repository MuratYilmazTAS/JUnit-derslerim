package tests.day12_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_ReusableMethodsTumSayfaSS extends TestBase {
    @Test
    public void test01(){
        // wisequarter anasayfaya gidin.
        driver.get("https://www.wisequarter.com");

        // urlnin wise icerdigini test edin
        String expectedUrlIcerik = "wise";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        //tumsayfa screenshot alin

        ReusableMethods.tumSayfaFotoCek(driver);
    }
}
