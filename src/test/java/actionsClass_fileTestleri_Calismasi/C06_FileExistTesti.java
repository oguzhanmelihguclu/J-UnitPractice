package actionsClass_fileTestleri_Calismasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_FileExistTesti {

    @Test
    public void test01(){


        String denemeDosyaYolu = "src/test/java/day09_actionsClass_fileTestleri/deneme.txt";


        System.out.println(      Files.exists(Paths.get(denemeDosyaYolu))     ); // true


        String yanlisDosyaYolu = "src/test/java/day09_actionsClass_fileTestleri/deneme1.txt";

        System.out.println(  Files.exists(Paths.get(yanlisDosyaYolu))  ); // false


        Assertions.assertTrue(  Files.exists(Paths.get(denemeDosyaYolu))   ); // PASSED


        // day09 package'i altinda deneme1.txt dosyasinin
        // var olmadigini test edin

        Assertions.assertFalse( Files.exists(Paths.get(yanlisDosyaYolu)) ); // PASSED


        // downloads klasorunde deneme.txt dosyasinin var oldugunu test edin

        String downloadsDenemeDosyaYolu = "C:\\Users\\oğuz\\Downloads\\deneme.txt";


        Assertions.assertTrue( Files.exists(Paths.get(downloadsDenemeDosyaYolu)) );

    }
}
