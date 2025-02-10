package JsAlerts_iFrame_Calismasi;

import org.junit.jupiter.api.Test;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C01_HTML_Alerts extends TestBaseEach {

    @Test
    public void test01(){

        // google anasayfaya gidin
        driver.get("https://www.google.com");

        ReusableMethods.bekle(1);

        // cookies kabul edin

      //  driver.findElement(By.xpath("//div[text()='Accept all']"))
      //          .click();

        ReusableMethods.bekle(5);

    }

}
