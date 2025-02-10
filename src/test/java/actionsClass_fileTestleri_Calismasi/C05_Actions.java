package actionsClass_fileTestleri_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C05_Actions extends TestBaseEach {

    @Test
    public void test01(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverOver1 = driver.findElement(By.xpath("(//*[@*='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(2);

        actions.moveToElement(hoverOver1).perform();
        ReusableMethods.bekle(2);
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[.='Link 1'])[1]"))
                .click();

        //4- Popup mesajini yazdirin
        System.out.println( driver.switchTo().alert().getText() );
        ReusableMethods.bekle(2);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo()
                .alert()
                .accept();


        //6- “Click and hold" kutusuna basili tutun
        WebElement clickBoxElementi = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickBoxElementi).perform();
        ReusableMethods.bekle(2);
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        System.out.println(clickBoxElementi.getText());


        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickElementi = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickElementi).perform();

        ReusableMethods.bekle(2);
        // cift tiklandigini test edin

        String expectedClassAttributeDegeri = "div-double-click double";
        String actualClassAttributeDegeri = doubleClickElementi.getAttribute("class");

        Assertions.assertEquals(expectedClassAttributeDegeri,actualClassAttributeDegeri);


        ReusableMethods.bekle(3);
    }
}
