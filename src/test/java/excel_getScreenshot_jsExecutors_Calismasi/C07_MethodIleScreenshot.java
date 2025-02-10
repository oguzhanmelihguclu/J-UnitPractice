package excel_getScreenshot_jsExecutors_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_MethodIleScreenshot extends TestBaseEach {

    @Test
    public void test01(){

        // Testotomasyonu anasayfaya gidelim
        driver.get("https://www.testotomasyonu.com");

        // Account linkine tiklayin
        driver.findElement(By.xpath("//span[.='Account']"))
                .click();


        // Kullanici adi olarak wise@gmail.com girin
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("12345");

        // sign in butonuna basarak sisteme giris yapin
        driver.findElement(By.id("submitlogin"))
                .click();
        ReusableMethods.bekle(1);
        // giris yapilabildigini test etmek icin
        // Logout butonunun gorunur oldugunu test edin

        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        // Logout butonunun fotografini cekin
        //ReusableMethods.webElementScreenshotIsimli(logoutButonu,"loginTesti");
        //ReusableMethods.webElementScreenshotTarihli(logoutButonu);
        ReusableMethods.webElementScreenshotTarihVeIsimli(logoutButonu,"loginTesti");

        // logout butonuna basarak sistemden cikis yapin
        logoutButonu.click();


    }
}
