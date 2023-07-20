package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseQuit;

public class C02_SwitchingWindows extends TestBaseQuit {

    @Test
    public void test01(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // url'nin amazon icerdigini test edin
        String expectedUrlIcerik = "amazon";
        String actualUrlIcerik= driver.getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
        bekle(2);

        // yeni bir tab olarak wisequarter anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        // title'in Wise icerdigni test edin
        String expectedTitleIcerik = "Wise";
        String actualTitleIcerik = driver.getTitle();
        Assert.assertTrue(actualTitleIcerik.contains(expectedTitleIcerik));
        bekle(2);

        // yeni bir window acarak youtube sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        // url'nin youtube icerdigini test edin
        expectedUrlIcerik="youtube";
        actualUrlIcerik= driver.getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));


        bekle(3);

        // acilan tum sayfalari kapatin.

    }
}
