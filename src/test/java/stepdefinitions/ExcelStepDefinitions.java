package stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelStepDefinitions {
    Workbook workbook;
    Sheet sheet1;
    String satirdakiUrunIsmi;
    Double satridakiMinUrunAdedi;
    Integer testOtomasyonundaBulunanSonucSayisi;
    String excelDosyaYolu;


    @Then("urun excelindeki {string} daki urunun min.miktarini ve urun ismini kaydeder")
    public void urun_excelindeki_daki_urunun_min_miktarini_ve_urun_ismini_kaydeder(String calisilanSatirNoStr) {
        int calisilanSatirNo=Integer.parseInt(calisilanSatirNoStr);
        satirdakiUrunIsmi=sheet1.getRow(calisilanSatirNo-1)
                                 .getCell(0)
                                  .getStringCellValue();//indeks oldugu icin bir cikardik

       satridakiMinUrunAdedi=sheet1.getRow(calisilanSatirNo-1).getCell(1).getNumericCellValue();

    }
    @Then("urun ismini testotomasyonu sayfasinda arar ve sonuc sayisini kaydeder")
    public void urun_ismini_testotomasyonu_sayfasinda_arar_ve_sonuc_sayisini_kaydeder() {
        TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(satirdakiUrunIsmi+ Keys.ENTER);

        //çıkan urun sayısı yazısından rakamı almak bize daha cok işlem yaptırsa da
        // test süresi implicity waiti beklemeyeceği için daha kısa sürer

        String aramaSonucuStr=testOtomasyonuPage.aramaSonucuUrunSayisiElementi.getText();
        //4 products gelir buradan 4 u cekeceğiz
        aramaSonucuStr=aramaSonucuStr.replaceAll("\\D","");//"4"
        testOtomasyonundaBulunanSonucSayisi=Integer.parseInt(aramaSonucuStr);



    }
    @Then("bulunan urun sayisinin excel'deki min. miktara esit veya daha fazla oldugunu test eder")
    public void bulunan_urun_sayisinin_excel_deki_min_miktara_esit_veya_daha_fazla_oldugunu_test_eder() {

        Assertions.assertTrue(testOtomasyonundaBulunanSonucSayisi>=satridakiMinUrunAdedi);

    }
    @Then("bulunan sonuc sayisini excelde {string} daki {int}. sutuna yazdirir")
    public void bulunan_sonuc_sayisini_excelde_daki_sutuna_yazdirir(String calisilanSatirNoStr, Integer sutunNo) throws IOException {

        int calisilanSatirNo=Integer.parseInt(calisilanSatirNoStr);
        sheet1.getRow(calisilanSatirNo-1).createCell(sutunNo-1).setCellValue(testOtomasyonundaBulunanSonucSayisi);
        FileOutputStream fileOutputStream=new FileOutputStream(excelDosyaYolu);
        workbook.write(fileOutputStream);


    }


    @When("exel dosyasi ile ilgili ayarlari yapip Sheet{int}'e gelir")
    public void exelDosyasiIleIlgiliAyarlariYapipSheetEGelir(int onemsiz) throws IOException {
        excelDosyaYolu="src/test/resources/features/urunListesison.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excelDosyaYolu);
        workbook= WorkbookFactory.create(fileInputStream);
        sheet1=workbook.getSheet("Sheet1");//exceldeki hali yazilir

    }
}
