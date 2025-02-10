package actionsClass_fileTestleri_Calismasi;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class C03_FakerClassKullanimi {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.name().firstName()); // Terica
        System.out.println(faker.name().nameWithMiddle()); // Mana Weissn at Beer
        System.out.println(faker.name().username()); // rossana.kuhlman

        System.out.println(faker.address().zipCode()); // 13304
        System.out.println(faker.address().fullAddress()); // 6469 Jeanette Valley, Port Antonette, MS 41908
        System.out.println(faker.address().cityName());//Marthaberg

        System.out.println(faker.internet().emailAddress()); // nolan.quitzon@yahoo.com
        System.out.println(faker.internet().password()); //6nzq78c1jsl
        System.out.println(faker.internet().url());// www.domitila-kub.org


        System.out.println(faker.harryPotter().character()); // Vernon Dursley

        System.out.println(faker.gameOfThrones().character()); // Orland of Oldtown
        System.out.println(faker.lordOfTheRings().character()); // Aragorn


    }
}
