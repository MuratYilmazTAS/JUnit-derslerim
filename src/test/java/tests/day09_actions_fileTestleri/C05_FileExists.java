package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_FileExists  {
    @Test
    public void test01(){

        // /Users/murattas/Downloads.avatar.png

        /*
        bir dosyanin bilgisayarimizda oldugunu test etmek cok kolaydir
        ancak testimizin dinamik olmasini saglamak
         */

        //bir dosyanin bilgisayarimizda var oldugunu test etmek istersek
        Assert.assertTrue(Files.exists(Paths.get("/Users/murattas/Downloads/avatar.png")));
    }
    @Test
    public void dinamikTest(){
        // dosya yolunu dinamik yapalim

        // javada dosya yolunu bize veren 2 tane kod var

        // 1- calistigimiz klasorun dosya yolunu almak isterseniz
        System.out.println(System.getProperty("user.dir")); // /Users/murattas/Desktop/team116_JUnit

        // 2- bilgisayarimizin ana dosya yolu
        System.out.println(System.getProperty("user.home")); // /Users/murattas

        // bu bilgileri kullanarak
        // indirdigimiz dosyanin dinamik dosya yolunu elde etmek istersek
        // iki parcada elde edebiliriz.
        // (System.getProperty("user.home") + herkeste ayni olan kisim

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Download/avatar.png";
        System.out.println(dinamikDosyaYolu);

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

    }

    @Test
    public void masaustu(){
        //avatar resmini masaustune kopyalayin
        //masaustunde acatar resmi olup olmadigini test edin

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/avatar.png";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        System.out.println(dinamikDosyaYolu);
    }
}
