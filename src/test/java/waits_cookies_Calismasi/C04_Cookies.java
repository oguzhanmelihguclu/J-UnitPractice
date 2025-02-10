package waits_cookies_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

import java.util.Set;

public class C04_Cookies extends TestBaseEach {

    @Test
    public void test01(){

        // Google'a gidelim
        driver.get("https://www.google.com");


        // cookies cikarsa kabul edin

      //  driver.findElement(By.xpath("//div[.='Accept all']"))
      //          .click();

        // syfada kac adet cookies bulundugunu yazdirin

        Set<Cookie> tumCookieSeti  = driver.manage().getCookies();

        System.out.println("Sayfadaki cookie adedi : " + tumCookieSeti.size()); // 3

        // sayfadaki cookie'leri yazdirin

        System.out.println(tumCookieSeti);

        // daha derli toplu yazdiralim

        int siraNo = 1;

        for (Cookie eachCookie : tumCookieSeti ){

            System.out.println(siraNo + ".cookie  :  " + eachCookie);
            siraNo++;
        }

        System.out.println("=============");
        // cookie'lerin isimlerini yazdirin

        siraNo = 1;
        for (Cookie eachCookie : tumCookieSeti ){

            System.out.println(siraNo + ".cookie ismi :  " + eachCookie.getName());
            siraNo++;
        }

        // ismi SOCS olan cookie'nin degerinin
        // "CAISHAgBEhJnd3NfMjAyNDEyMDMtMF9SQzEaAmVuIAEaBgiA5ti6Bg" oldugunu test edin

        String expectedDeger = "CAISHAgBEhJnd3NfMjAyNDEyMDMtMF9SQzEaAmVuIAEaBgiA5ti6Bg";
        String actualDeger= driver.manage().getCookieNamed("SOCS").getValue();

        Assertions.assertEquals(expectedDeger,actualDeger);

        // ismi enSevdigimCookie, degeri cikolataliCookie olan bir cookie olusturup
        // sayfaya ekleyin
        Cookie benimCookie = new Cookie("enSevdigimCookie","cikolataliCookie");
        driver.manage().addCookie(benimCookie);

        // tum cookie'leri yazdiralim
        System.out.println("=============");
        // cookie'lerin isimlerini yazdirin

        tumCookieSeti = driver.manage().getCookies();
        siraNo = 1;
        for (Cookie eachCookie : tumCookieSeti ){

            System.out.println(siraNo + ".cookie  :  " + eachCookie);
            siraNo++;
        }

        // cookie'yi ekleyebildigimizi test edin

        Assertions.assertTrue(tumCookieSeti.contains(benimCookie));


        // ismi SOCS olan cookie'yi silin

        driver.manage().deleteCookieNamed("SOCS");

        // tum cookie'leri yazdiralim
        System.out.println("=============");
        // cookie'lerin isimlerini yazdirin

        tumCookieSeti = driver.manage().getCookies();
        siraNo = 1;
        for (Cookie eachCookie : tumCookieSeti ){

            System.out.println(siraNo + ".cookie  :  " + eachCookie);
            siraNo++;
        }

        // ve silindigini test edin

        boolean socsVarMi = false;

        for (Cookie eachCookie : tumCookieSeti ){

            if (eachCookie.getName().equals("SOCS")){
                socsVarMi= true;
            }
        }

        // tum cookie'lerin isimlerini kontrol ettik
        // ismi SOCS olan varsa socsVarMi= true,
        // ismi SOCS olan yoksa socsVarMi= false, olacak

        Assertions.assertFalse(socsVarMi);


        // tum cookie'leri silin
        driver.manage().deleteAllCookies();


        // ve silindigini test edin
        tumCookieSeti = driver.manage().getCookies();

        System.out.println("=============");
        System.out.println(tumCookieSeti);

        Assertions.assertEquals(0,tumCookieSeti.size());


        ReusableMethods.bekle(1);
    }
}
