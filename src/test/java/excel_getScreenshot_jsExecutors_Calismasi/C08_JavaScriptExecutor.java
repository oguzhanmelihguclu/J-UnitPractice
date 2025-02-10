package excel_getScreenshot_jsExecutors_Calismasi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_JavaScriptExecutor extends TestBaseEach {

    @Test
    public void test01(){

        // https://testotomasyonu.com/form sayfasina gidin
        driver.get("https://testotomasyonu.com/form");

        // isitme kaybi checkbox gorunecek kadar asagi inin

            // 1.adim jse objesi olustur
        JavascriptExecutor jse = (JavascriptExecutor) driver;

            // 2.adim kullanmak istedigimiz Webelementi locate edip kaydedin
        WebElement isitmeKaybiCheckBox = driver.findElement(By.id("hastalikCheck5"));

            //3.adim jse.executeScript() ile istenen islemi yapin
        //jse.executeScript("arguments[0].scrollIntoView(true);",isitmeKaybiCheckBox);
        // bu kod webelementi gosterir ama tam ortalamaz

        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", isitmeKaybiCheckBox);
        ReusableMethods.bekle(5);

        // jse kullanarak isitme kaybi checkbox'i isaretleyin

        jse.executeScript("arguments[0].click();",isitmeKaybiCheckBox);


        ReusableMethods.bekle(5);

        jse.executeScript("alert('JUnit BITTTIIIII');");

        ReusableMethods.bekle(5);

    }
}
