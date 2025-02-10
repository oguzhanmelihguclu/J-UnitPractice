package windowSwitch_actionsClass_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_KontrolluWindowDegistirme extends TestBaseEach {

    @Test
    public void test01(){


        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // whd'ini kaydedin ve yazdirin
        String testOtomasyonuWhd = driver.getWindowHandle();
        System.out.println("test otomasyonu whd : " + testOtomasyonuWhd);
        ReusableMethods.bekle(2);

        // yeni bir tab acip, yeni tab'da wisequarter sayfasina gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        // whd'ini kaydedin ve yazdirin
        String wisequarterWhd = driver.getWindowHandle();
        System.out.println("Wisequarter whd : " + wisequarterWhd);
        ReusableMethods.bekle(2);

        // yeni bir window acarak, arabam.com sayfasina gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.arabam.com");

        // whd'ini kaydedin ve yazdirin
        String arabamWhd = driver.getWindowHandle();
        System.out.println("Arabam whd : " + arabamWhd);
        ReusableMethods.bekle(2);

        // wisequarter'in acik oldugu window'a donun
        // ve url'in wisequarter icerdigini test edin


        driver.switchTo().window(wisequarterWhd);
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);

        // testotomasyonu'nun acik oldugu window'a donun
        // ve url'in testotomasyonu icerdigini test edin

        driver.switchTo().window(testOtomasyonuWhd);

        expectedUrlIcerik = "testotomasyonu";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
        ReusableMethods.bekle(2);


    }
}
