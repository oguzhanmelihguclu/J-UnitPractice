package windowSwitch_actionsClass_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_WindowDegistirme extends TestBaseEach {

    @Test
    public void test01(){

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // sayfadaki elemental selenium linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']"))
                .click();

        // acilan yeni window'da buyuk basligin "Elemental Selenium" oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(driver,"https://elementalselenium.com/");

        String expectedYazi = "Elemental Selenium";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        // ilk window'a geri donun
        ReusableMethods.titleIleWindowDegistir(driver,"The Internet");

        // "Opening a new window" yazisinin gorunur oldugunu test edin
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(yaziElementi.isDisplayed());

        // Click here'a basin
        driver.findElement(By.xpath("//*[.='Click Here']"))
                .click();

        // Acilan yeni window'a gecip, oradaki yazinin "New Window" oldugunu test edin
        ReusableMethods.titleIleWindowDegistir(driver,"New Window");

        yaziElementi = driver.findElement(By.tagName("h3"));

        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        // Elemental selenium'un acik oldugu window'a gecip
        // Tips linkinin erisilebilir oldugunu test edin

        ReusableMethods.urlIleWindowDegistir(driver,"https://elementalselenium.com/");

        WebElement tipsElementi = driver.findElement(By.xpath("//a[.='Tips']"));

        Assertions.assertTrue(tipsElementi.isEnabled());

        ReusableMethods.bekle(2);

    }
}
