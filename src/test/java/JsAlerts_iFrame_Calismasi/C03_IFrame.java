package JsAlerts_iFrame_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C03_IFrame extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        //2- Elektronics Products yazisinin gorunur olduğunu test edin


        WebElement electronicsIframeElementi = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(electronicsIframeElementi);

        WebElement electronicsProductsYaziElementi =
                driver.findElement(By.xpath("//*[text()='Electronics Products']"));

        Assertions.assertTrue(electronicsProductsYaziElementi.isDisplayed());

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellElementi = driver.findElement(By.id("pictext1"));

        String expectedUrunIsmi ="DELL Core I3 11th Gen";
        String actualUrunIsmi = dellElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi,actualUrunIsmi);

        //4- Sale Up To 50% yazisinin gorunur oldugunu test edin

        driver.switchTo().defaultContent();
        // ic ice birden fazla katman olarak iFrame'ler varsa
        // direk anasayfaya cikartir

        WebElement saleUpYaziElementi = driver.findElement(By.xpath("//*[text()='Sale Up To 50%']"));

        Assertions.assertTrue(saleUpYaziElementi.isDisplayed());

        // 5- Fashion bolumundeki ilk urunu tiklayin

        WebElement fashionIframe = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(fashionIframe);

        // artik ilk urun isminde "Men Slim Fit" gectigini test edin
        WebElement fashionIlkElement = driver.findElement(By.xpath("(//*[@class='overlay'])[1]"));

        String expectedIsimIcerik = "Men Slim Fit";
        String actualIsim = fashionIlkElement.getText();

        Assertions.assertTrue(actualIsim.contains(expectedIsimIcerik));

        ReusableMethods.bekle(3);
    }
}
