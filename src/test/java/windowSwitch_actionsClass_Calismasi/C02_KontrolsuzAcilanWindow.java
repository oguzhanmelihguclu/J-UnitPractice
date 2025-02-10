package windowSwitch_actionsClass_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C02_KontrolsuzAcilanWindow extends TestBaseEach {

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "Opening a new window";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle ="The Internet";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);
        ReusableMethods.bekle(2);

        String ilkWindowWhd = driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']"))
                .click();
        ReusableMethods.bekle(5);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu test edin
        System.out.println("Click here'a bastiktan sonra title : " + driver.getTitle());


        Set<String> tumWhdSeti = driver.getWindowHandles();
        System.out.println("Ilk window'un whd : " + ilkWindowWhd);
        System.out.println("Tum window handle degerleri seti : " + tumWhdSeti);
        String ikinciWindowWhd ="";

        for(String each : tumWhdSeti) {
            if(! each.equals(ilkWindowWhd))  {
                ikinciWindowWhd= each;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);
        System.out.println("Bulmaca cozdukten sonra title : " + driver.getTitle());


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        yaziElementi = driver.findElement(By.tagName("h3"));

        expectedYazi = "New Window";
        actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi,actualYazi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        //  “The Internet” olduğunu test edin

        driver.switchTo().window(ilkWindowWhd);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);


    }
}
