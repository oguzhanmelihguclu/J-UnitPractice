package actionsClass_fileTestleri_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C09_FileUploadTesti extends TestBaseEach {

    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/deneme.txt";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        ReusableMethods.bekle(1);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();
        ReusableMethods.bekle(3);
        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedYaziElementi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(fileUploadedYaziElementi.isDisplayed());

    }
}
