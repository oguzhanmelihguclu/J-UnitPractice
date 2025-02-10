package JsAlerts_iFrame_Calismasi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBaseEach;

public class C05_AyniWindowdaGezinme extends TestBaseEach {

    @Test
    public void test01(){

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Ana sayfa url : " + driver.getCurrentUrl());
        System.out.println("Ana sayfa whd : " + driver.getWindowHandle());


        // Electronics linkini tiklayin
        driver.findElement(By.xpath("(//*[@class='has-sub'])[1]"))
                .click();


        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics url : " + driver.getCurrentUrl());
        System.out.println("Electronics whd : " + driver.getWindowHandle());


        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box mb-2 pb-1'])[1]"))
                .click();


        // windowhandle degerini ve url'i yazdirin
        System.out.println("Ilk urun url : " + driver.getCurrentUrl());
        System.out.println("Ilk urun whd : " + driver.getWindowHandle());


        // account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("account url : " + driver.getCurrentUrl());
        System.out.println("account whd : " + driver.getWindowHandle());



    }
}
