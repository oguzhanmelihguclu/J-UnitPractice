package waits_cookies_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ExplicitWait {

    //Iki tane metod olusturun : implicitWaitTest , explicitWaitTest
    //Iki metod icin de asagidaki adimlari test edin.
    //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //2. Textbox’in etkin olmadigini(enabled) dogrulayın
    //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
    //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

    WebDriver driver;

    @Test
    public void implicitlyWaitTesti(){

        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox= driver.findElement(By.xpath("//input[@type='text']"));

        Assertions.assertFalse(textbox.isEnabled());

        //3. Enable butonuna tıklayın
        WebElement enableButonu = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButonu.click();
        // ve textbox etkin oluncaya kadar bekleyin
        // testimiz implicitlyWaitTest oldugu icin
        // implicitly wait'in yeterli olup olmadigini gormek icin
        // ekstra bekleme koymadik

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.

       ReusableMethods.bekle(4);
       Assertions.assertTrue(textbox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());

        ReusableMethods.bekle(1);
        driver.quit();

    }

    @Test
    public void explicitWaitTesti(){

        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox= driver.findElement(By.xpath("//input[@type='text']"));
        Assertions.assertFalse(textbox.isEnabled());

        //3. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButonu = driver.findElement(By.xpath("(//button[@type='button'])[2]"));

        enableButonu.click();
        // ve textbox etkin oluncaya kadar bekleyin
        // explicitlyWait ile bekleyelim

            // 1.adim bir wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            // 2.adim MUMKUNSE beklenecek objeyi locate edip bir webelement olarak kaydedin
            //        textbox'i locate edebiliyoruz ve yukarda locate edip kaydettik

            // 3.adim wait objesine neyi bekleyecegini soyleyin
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        //4. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assertions.assertTrue(textbox.isEnabled());

        //5. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        WebElement itsEnabledYaziElementi = driver.findElement(By.id("message"));

        Assertions.assertTrue(itsEnabledYaziElementi.isDisplayed());


        ReusableMethods.bekle(1);
        driver.quit();
    }



}
