package WebTables_ExcelOtomasyon_Calismasi;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void test01() throws IOException {

        // Gerekli ayarlamalari yapip, ulkeler excel'indeki sayfa2'ye gidin
        String dosyaYolu = "src/test/java/day11_WebTables_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa2Obj = workbook.getSheet("Sayfa2");

        // Kullanilan son satirin 20.satir oldugunu test edin

        int expectedSonSatirNo = 20;
        int actualSonSatirNo = sayfa2Obj.getLastRowNum()+1;

        Assertions.assertEquals(expectedSonSatirNo,actualSonSatirNo);


        // Kullanilan (bos birakilmayan) satir sayisinin 8 oldugunu test edin
        int expectedKullanilanSatirSayisi = 8;
        int actualKullanilanSatirSayisi = sayfa2Obj.getPhysicalNumberOfRows();

        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);


        // 17.satir 5.hucredeki bilgiyi yazdirin
        System.out.println(sayfa2Obj.getRow(16).getCell(4)); // null
        // satir var ama istenen hucrede bilgi yok


        // 5.satir 3.hucredeki bilgiyi yazdirin

        System.out.println(sayfa2Obj.getRow(4)); // null

        // System.out.println(sayfa2Obj.getRow(4).getCell(2)); // NullPointerException





    }
}
