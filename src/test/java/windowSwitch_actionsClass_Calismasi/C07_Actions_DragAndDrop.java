package windowSwitch_actionsClass_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C07_Actions_DragAndDrop extends TestBaseEach {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);
        WebElement acceptableButtonElement = driver.findElement(By.xpath("//*[.='Acceptable']"));
        WebElement dropHereElement = driver.findElement(By.xpath("//*[.='Drop Here']"));

        actions.dragAndDrop(acceptableButtonElement,dropHereElement).perform();


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi = "Dropped!";
        String actualYazi= driver.findElement(By.id("droppable2"))
                                            .getText();

        Assertions.assertEquals(expectedYazi,actualYazi);


        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        ReusableMethods.bekle(1);

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElement = driver.findElement(By.xpath("//*[.='Not Acceptable']"));
        dropHereElement = driver.findElement(By.xpath("//*[.='Drop Here']"));

        actions.dragAndDrop(notAcceptableElement,dropHereElement).perform();

        //6- “Drop Here” yazisinin degismedigini test edin
        expectedYazi = "Drop Here";
        actualYazi = dropHereElement.getText();
        Assertions.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(1);
    }
}
