package excel_getScreenshot_jsExecutors_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_MethodIleGetScreenshot extends TestBaseEach {

    @Test
    public void test01(){

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu =  "0 Products Found";
        String actualAramaSonucu = sonucYaziElementi.getText();

        Assertions.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);
        ReusableMethods.bekle(1);
        // tum sayfa screenshot alin
        //ReusableMethods.tumSayfaScreenshotIsimli(driver,"aramaTesti");
        //ReusableMethods.tumSayfaScreenshotTarihli(driver);
        ReusableMethods.tumSayfaScreenshotIsimVeTarihli(driver,"aramaTesti");

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));

        // sayfanin fotografini cekin
        ReusableMethods.bekle(1);
        //ReusableMethods.tumSayfaScreenshotIsimli(driver,"IlkUrunIsimTesti");
        //ReusableMethods.tumSayfaScreenshotTarihli(driver);
        ReusableMethods.tumSayfaScreenshotIsimVeTarihli(driver,"C05_MethodIleGetScreenshot");
    }
}
