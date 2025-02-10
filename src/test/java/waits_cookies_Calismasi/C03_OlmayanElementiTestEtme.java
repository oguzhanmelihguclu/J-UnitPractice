package waits_cookies_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

public class C03_OlmayanElementiTestEtme extends TestBaseEach {

    @Test
    public void test01(){



        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //2. Remove butonuna basin.
        WebElement chexboxButonu=driver.findElement(By.xpath("(//*[@*='checkbox'])[2]"));
        WebElement removeButonu =driver.findElement(By.xpath("(//*[@*='button'])[1]"));

        removeButonu.click();

        // it's gone yazisi gorununceye kadar bekleyin
        WebElement itsGoneYaziElementi = driver.findElement(By.id("message"));


        //3. checkbox'in gorunur olmadigini test edin
        /*
            checkbox'i daha onceden locate ettigimiz icin
            StaleElementReferenceException verdi,

            eger onceden locate etmemis olsaydik
            bu satirda locate etmeye calissaydik
            implicitlyWait suresi kadar bekler ve sonra
            NoSuchElementException verirdi.

         */

        try {
            chexboxButonu.click();
            Assertions.assertTrue(false,"checkbox gorunur durumda");
            // checkbox kutusunun OLMAMASI gerekiyor
            // VARSA ve click yapabildi isek TEST FAILED OLAMALIDIR
        } catch (StaleElementReferenceException e) {
            // StaleElementReferenceException olusmasi
            // o elementin gorunur olmadigini ispatlar
            // testin PASSED OLMASI gerekir
            Assertions.assertTrue(true);
        }

        //4. Add buttonuna basin
        //5. checkbox'in gorunur oldugunu test edin

    }

}
