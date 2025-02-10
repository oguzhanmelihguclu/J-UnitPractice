package windowSwitch_actionsClass_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C08_Actions_MoveToElement extends TestBaseEach {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        Actions actions = new Actions(driver);
        WebElement kidsWearButton = driver.findElement(By.xpath("(//li[@class='has-sub'])[7]"));

        actions.moveToElement(kidsWearButton).perform();
        ReusableMethods.bekle(2);
        //3- “Boys” linkine basin
        driver.findElement(By.xpath("//*[.='Boys']"))
                .click();

        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]"))
                .click();


        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement isimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedIsim = "Boys Shirt White Color";
        String actualIsim = isimElementi.getText();

        Assertions.assertEquals(expectedIsim,actualIsim);

        ReusableMethods.bekle(2);
    }

}
