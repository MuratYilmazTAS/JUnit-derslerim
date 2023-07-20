package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P10_SwitchTo extends TestBase {
    /*
    1- Gerekli ayarlamalari yapin
    2- google.com adresine gidin
    3-Google title'in Google icerdigini test edin
    4-Yeni bir pencerede wisequarter sayfasina gidelim
    5-wisequarter sayfasininin title'inin wise icerdigini test edin
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.google.com");
        String ilkSayfaWHD = driver.getWindowHandle();
        System.out.println("Ilk sayfanin acildigi yerin Handle Degeri: "+ilkSayfaWHD); // 2AC0788300B48753CDFDDBF593D2ACEF
        String expectedWords = "Google";
        String actualTitle = driver.getTitle();
        Thread.sleep(2000);

        Assert.assertTrue(actualTitle.contains(expectedWords));
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere aciyor
        Thread.sleep(2000);
        driver.get("https://www.wisequarter.com"); // yeni acilan pencerede adrese gidiyor
        String ikinciPencereWHD = driver.getWindowHandle();
        System.out.println("Ikinci pencere WHD: "+ikinciPencereWHD); // F8C087D6F9FEC740C99C005CF7C61C47
        String expectedWords2 = "Wise";
        String actualTitle2 = driver.getTitle();

        Assert.assertTrue(actualTitle2.contains(expectedWords2));

        driver.switchTo().window(ilkSayfaWHD);// WHD verilen pencereye gidiyor
        driver.get("https://www.amazon.com");
        String expectedWords3 = "Amazon";
        String actualTitle3 = driver.getTitle();

        Assert.assertTrue(actualTitle3.contains(expectedWords3));

        driver.switchTo().newWindow(WindowType.TAB); // yeni bir sekme aciyor
        driver.get("https://www.wisequarter.com"); // yeni acilan tab'daki adrese gidiyor
        String expectedWords4 = "Wise";
        String actualTitle4 = driver.getTitle();

        Assert.assertTrue(actualTitle4.contains(expectedWords4));

    }

}
