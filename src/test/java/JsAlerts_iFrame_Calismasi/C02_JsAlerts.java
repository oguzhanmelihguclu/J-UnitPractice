package JsAlerts_iFrame_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseEach;

public class  C02_JsAlerts extends TestBaseEach {

    @Test
    public void jsAlertsTest(){
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertYazi,actualAlertYazi);

        //	-  OK tusuna basip alert'i kapatin

        driver.switchTo()
                .alert()
                .accept();

    }

    @Test
    public void jsConfirmTest(){
        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();

        //	- Cancel'a basip,
        driver.switchTo()
                .alert()
                .dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        String expectedSonucYazisi = "You clicked: Cancel";

        WebElement sonucYazisiElementi = driver.findElement(By.id("result"));
        String actualSonucYazisi = sonucYazisiElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void jsPromptTest(){
        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();

        //	- Cikan prompt ekranina "Cansu" yazdiralim
        driver.switchTo().alert().sendKeys("Cansu");

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Cansu icerdigini test edelim

        String expectedSonucYaziIcerigi = "Cansu";

        WebElement sonucYazisiElementi = driver.findElement(By.id("result"));
        String actualSonucYazisi = sonucYazisiElementi.getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYaziIcerigi));

    }


}
