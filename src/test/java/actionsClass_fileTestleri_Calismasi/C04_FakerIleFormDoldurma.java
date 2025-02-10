package actionsClass_fileTestleri_Calismasi;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseEach;

public class C04_FakerIleFormDoldurma extends TestBaseEach {

    @Test
    public void test01(){

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//span[.='Account'])[1]"))
                .click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']"))
                .click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim


        WebElement firstNameKutusu = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String fakeSifre = faker.internet().password();
        String fakeEmail = faker.internet().emailAddress();


        ReusableMethods.bekle(1);

        actions.click(firstNameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeSifre).perform();

        ReusableMethods.bekle(5);

        //   ve Sign Up butonuna basalim
        driver.findElement(By.id("btn-submit-form")).click();


        //5- Kaydin olusturuldugunu test edin

        WebElement emailKutusu = driver.findElement(By.id("email"));
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        WebElement submitButonu = driver.findElement(By.id("submitlogin"));

        emailKutusu.sendKeys(fakeEmail);
        passwordKutusu.sendKeys(fakeSifre);
        submitButonu.click();


        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonu.isDisplayed());

        logoutButonu.click();

        ReusableMethods.bekle(2);
    }
}
