package actionsClass_fileTestleri_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class  C07_DosyaYolunuDinamikYapma {

    @Test
    public void test01(){

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String downloadsDenemeDosyaYolu = "C:\\Users\\oğuz\\Downloads\\deneme.txt";

        Assertions.assertTrue( Files.exists(Paths.get(downloadsDenemeDosyaYolu)) );


        /*
            /Users/ahmetbulutluoz       /Users/ahmetbulutluoz        /Downloads/deneme.txt
            \\Users\\Cansu              C:\Users\Cansu               \\Downloads\\deneme.txt
            C:\\Users\\Hamza            C:\Users\Hamza               \\Downloads\\deneme.txt
            C:\\Users\\coban            C:\Users\coban               \\Downloads\\deneme.txt
            C:\\Users\\GS               C:\Users\GS                  \\Downloads\\deneme.txt
         */

        String dinamikAnaDosyaYolu = System.getProperty("user.home");
        System.out.println(dinamikAnaDosyaYolu);

        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin


        String dinamikDosyaYolu = System.getProperty("user.home") + "/Downloads/deneme.txt";
        Assertions.assertTrue(  Files.exists(Paths.get(dinamikDosyaYolu)) );




        // day09 package'i altinda deneme.txt dosyasinin
        // var oldugunu test edin

        String denemeDosyaYolu = "src/test/java/day09_actionsClass_fileTestleri/deneme.txt";

        System.out.println(      Files.exists(Paths.get(denemeDosyaYolu))     ); // true


        System.out.println( System.getProperty( "user.dir"  ) );
        //  herkeste farkli olan kisim :    /Users/ahmetbulutluoz/Desktop/My Desktop/course/projeler/Team148_JUnit
        //  herkeste ayni olan kisim   :    /src/test/java/day09_actionsClass_fileTestleri/deneme.txt


        String dinamikProjeDosyaYolu = System.getProperty( "user.dir"  );

        dinamikDosyaYolu = dinamikProjeDosyaYolu + "/src/test/java/day09_actionsClass_fileTestleri/deneme.txt";

        Assertions.assertTrue( Files.exists(Paths.get(dinamikDosyaYolu)));

    }
}
