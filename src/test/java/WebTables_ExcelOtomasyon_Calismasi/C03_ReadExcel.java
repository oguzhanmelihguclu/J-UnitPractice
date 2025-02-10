package WebTables_ExcelOtomasyon_Calismasi;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Excel'deki bilgileri kullanabilmek icin
        // once excel'deki datalara ulasmamiz lazim
        // bilgisayarimizdaki dosyaya selenium WebDriver ile ulasamayacagimiz icin
        // Java'dan yardim istemeliyiz

        // 1.adim dosya yolunu alalim
        String dosyaYolu = "src/test/java/day11_WebTables_ExcelOtomasyon/ulkeler.xlsx";

        // 2.adim Java ile dosyaya erismek icin
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // 3.adim Excel'den alinan bilgileri
        //   kodlarimizin icinde olusturacagimiz bir obje olarak kaydedelim
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Artik fiziki excel dosyasindaki tum bilgileri
        // kodlarimiz icersinde olusturdugumuz workbook objesine kaydettik.

        // 4.adim excel'in kopyasi olan workbook'da
        //        istedigimiz bilgiye ulasalim

        // Sayfa1'deki 5.satir, 3.hucrede olan bilgiyi yazdirin
        // workbook da Java'daki genel kabule uygun olarak
        // index kullanir
        // index 0'dan basladaigi icin
        // 5.satir icin index==>4, 3.hucre icin index==>2 secilmelidir

        Sheet sheet1 = workbook.getSheet("Sayfa1");

        Row row = sheet1.getRow(4);

        Cell cell = row.getCell(2);

        System.out.println("Sayfa1 5.satir, 3.sutun : "+ cell); // Andorra


        // her seferinde row ve cell olusturmaya gerek yok
        // Sayfa1'deki 15.satir, 2.hucrede olan bilgiyi yazdirin

        System.out.println(workbook.getSheet("Sayfa1").getRow(14).getCell(1)); // Dhaka


        // son satir numarasini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()); // 190
        // bu son satirin index'idir

        System.out.println("Son satir no : " + (workbook.getSheet("Sayfa1").getLastRowNum()+1));


        // Kullanilan satir sayisini yazdirin
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows()); // 191


    }
}
