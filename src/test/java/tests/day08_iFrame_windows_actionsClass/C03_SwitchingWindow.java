package tests.day08_iFrame_windows_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseQuit;

public class C03_SwitchingWindow extends TestBaseQuit {

    @Test
    public void test01(){



        driver.get("https://www.amazon.com");
        String wHDAmazon = driver.getWindowHandle();
        bekle(2);

        // yeni bir tab olarak wisequater 'a gidelim
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        String wHDWise = driver.getWindowHandle();
        bekle(2);

        //yeni bir sayfa olarak youtube'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.youtube.com");
        String wHDYoutube = driver.getWindowHandle();
        bekle(2);


        //amazonun acik oldugu sayfaya donun ve url'in amazon icerdigini test edin.
        driver.switchTo().window(wHDAmazon);
        String expectedUrlIcerik = "amazon";
        String actualUrlIcerik= driver.getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
        bekle(2);



        // wisequarter'in acik oldugu sayfaya gidin ve title'in wise icerdigini test edin
        driver.switchTo().window(wHDWise);
        String expectedTitleIcerik = "Wise";
        String actualTitleIcerik = driver.getTitle();
        Assert.assertTrue(actualTitleIcerik.contains(expectedTitleIcerik));
        bekle(2);


        // youtube'un acik oldugu sayfaya gidin ve url'nin youtube icerdigini test edin
        driver.switchTo().window(wHDYoutube);
        expectedUrlIcerik="youtube";
        actualUrlIcerik= driver.getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));
        bekle(2);
    }
}
