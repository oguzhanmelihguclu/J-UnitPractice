package excel_getScreenshot_jsExecutors_Calismasi;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/day11_WebTables_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1Obj = workbook.getSheet("Sayfa1");

        // 1.satirdaki 2.hucreye gidin ve yazdirin
        System.out.println(sayfa1Obj.getRow(0).getCell(1)); // Başkent (İngilizce)

        // 1.satirdaki 2.hucreyi bir string degiskene atayin
        //	 ve degerinin “Başkent (İngilizce)” oldugunu test edin

        String satir1Hucre2 = sayfa1Obj.getRow(0).getCell(1).getStringCellValue();
        String expectedHucreDegeri = "Başkent (İngilizce)";

        Assertions.assertEquals(expectedHucreDegeri,satir1Hucre2);

        // 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        String expectedData = "Kabil";
        String actualData = sayfa1Obj.getRow(1).getCell(3).getStringCellValue();

        Assertions.assertEquals(expectedData,actualData);

        // Ulke sayisinin 190 oldugunu test edin

        int actualUlkeSayisi = sayfa1Obj.getLastRowNum() + 1 - 1;
        int expectedUlkeSayisi = 190;

        // +1  method bize index getiriyor, satir sayisini bulmak icin +1 ekliyoruz
        // -1  basta baslik satiri oldugundan satir sayisindan 1 cikartarak ulke sayisini bulabiliriz

        Assertions.assertEquals(expectedUlkeSayisi,actualUlkeSayisi);

        // Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin

        int actualKullanilanSatirSayisi = sayfa1Obj.getPhysicalNumberOfRows();
        int expectedKullanilanSatirSayisi = 191;

        Assertions.assertEquals(expectedKullanilanSatirSayisi,actualKullanilanSatirSayisi);


        // Ingilizce ismi Netherlands olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        // butun satirlari tek tek kontrol edip
        // 0.index'deki data Netherlands ise 3.index'deki data'nin Amsterdam oldugunu test edelim

        for (int i = 1; i <= sayfa1Obj.getLastRowNum() ; i++) {

            String satirdakiUlkeIsmi = sayfa1Obj.getRow(i).getCell(0).getStringCellValue();

            if (satirdakiUlkeIsmi.equals("Netherlands")){

                String actualTurkceBaskentIsmi = sayfa1Obj.getRow(i).getCell(3).getStringCellValue();
                Assertions.assertEquals("Amsterdam",actualTurkceBaskentIsmi);
                break;
            }
        }



        // Turkce baskent isimlerinde Ankara bulundugunu test edin

        boolean ankaraVarMi = false ;

        for (int i = 1; i <=sayfa1Obj.getLastRowNum() ; i++) {

            String satirdakiTurkceBaskentIsmi = sayfa1Obj.getRow(i).getCell(3).getStringCellValue();

            if (satirdakiTurkceBaskentIsmi.equals("Ankara")){
                ankaraVarMi = true;
                break;
            }

        }

        Assertions.assertTrue(ankaraVarMi);


        // Turkce baskent isminde A olan ulke sayisini bulun

        // Ingilizce ismi B ile baslayan kac ulke bulundugunu test edin




    }
}
