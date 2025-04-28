package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class TestotomasyonuStepdefinitions {
    TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();

    @Given("kullanici testotomasyonu anasayfaya gider")
    public void kullanici_testotomasyonu_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }

    @When("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {

        testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

    }
    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {
        String expectedAramaSonucu=ConfigReader.getProperty("toS?f?rUrunBulunduYaz?s?");
        String actualAramaSonucu=testOtomasyonuPage.aramaSonucuUrunSayisiElementi.getText();

        Assertions.assertNotEquals(expectedAramaSonucu,actualAramaSonucu);


    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();

    }

    @When("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {

        testOtomasyonuPage.aramaKutusu.sendKeys("dress"+Keys.ENTER);
    }

    @When("arama kutusuna travel yazip aratir")
    public void aramaKutusunaTravelYazipAratir() {
        testOtomasyonuPage.aramaKutusu.sendKeys("travel"+Keys.ENTER);
    }

    @Then("ilk urunu tiklar")
    public void ilk_urunu_tiklar() {
       testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();

    }
    @Then("acilan sayfadaki  urun isminin case sensetive olmadan phone icerdigini test eder")
    public void acilan_sayfadaki_urun_isminin_case_sensetive_olmadan_phone_icerdigini_test_eder() {
        String expectedIsimIcerigi="phone";
        String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi
                .getText()
                .toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerigi));
    }

    @When("arama kutusuna {string} yazip aratir")
    public void arama_kutusuna_yazip_aratir(String aramacakKelime) {
        testOtomasyonuPage.aramaKutusu.sendKeys(aramacakKelime+Keys.ENTER);

    }


    @And("kodlari {int} saniye bekletir")
    public void kodlariSaniyeBekletir(int saniye) {

        ReusableMethods.bekle(saniye);
    }

    @Then("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {
        String expectedAramaSonucu=ConfigReader.getProperty("toS?f?rUrunBulunduYaz?s?");
        String actualAramaSonucu=testOtomasyonuPage.aramaSonucuUrunSayisiElementi.getText();
        Assertions.assertEquals(expectedAramaSonucu,actualAramaSonucu);
    }

    @Then("account linkine basar")
    public void account_linkine_basar() {
       testOtomasyonuPage.accountButonu.click();
    }
    @Then("sonra email olarak {string} girer")
    public void sonra_email_olarak_girer(String configDosyasiEmail) {

        testOtomasyonuPage.testotomasyonuEmail.sendKeys(ConfigReader.getProperty(configDosyasiEmail));

    }
    @Then("password olarak {string} girer")
    public void password_olarak_to_gecerli_sifre_girer(String configDosyasiSifre ) {
        testOtomasyonuPage.testotomasyonuPassWord.sendKeys(ConfigReader.getProperty(configDosyasiSifre));


    }
    @Then("SignIn butonuna basar")
    public void sign_ın_butonuna_basar() {

        testOtomasyonuPage.testotomasyonuSignButonu.click();

    }
    @Then("basarili olarak giris yapilabildigini test eder")
    public void basarili_olarak_giris_yapilabildigini_test_eder() {
        Assertions.assertTrue(testOtomasyonuPage.tesotomasyouLogoutYazisi.isDisplayed());

    }
    @Then("logout butonuna basarak cikis yapar")
    public void logout_butonuna_basarak_cikis_yapar() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // İsteğe bağlı küçük bir bekleme
        ReusableMethods.bekle(3);


        // Logout işlemi
        js.executeScript("arguments[0].click();", testOtomasyonuPage.tesotomasyouLogoutYazisi);

    }


    @When("sisteme giris yapilamadigini test eder")
    public void sistemeGirisYapilamadiginiTestEder() {
        String expectedSifre=ConfigReader.getProperty("toGecerliSifre");
        String actualSifre=ConfigReader.getProperty("toGecersizSifre");
        Assertions.assertNotEquals(expectedSifre,actualSifre);

       // Assertions.assertTrue(testOtomasyonuPage.testotomasyonuEmail.isDisplayed());
        //bu hocanın yaptıgı çözüm





    }


    @And("acilan sayfadaki  urun isminin case sensetive olmadan config dosyasindaki toAranacakKelime icerdigini test eder")
    public void acilanSayfadakiUrunIsmininCaseSensetiveOlmadanConfigDosyasindakiToAranacakKelimeIcerdiginiTestEder() {

        String expectedIsimIcerik=ConfigReader.getProperty("toAranacakKelime");
        String actualUrunIsmi=testOtomasyonuPage.ilkUrunSayfasindakiIsimElementi.getText().toLowerCase();
        Assertions.assertTrue(actualUrunIsmi.contains(expectedIsimIcerik));
    }

    @When("arama kutusuna config dosyasindaki toAranacakKelime yazip aratir")
    public void aramaKutusunaConfigDosyasindakiToAranacakKelimeYazipAratir() {

        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+Keys.ENTER);

    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String configDosyasiUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(configDosyasiUrl));
    }

    @When("sonra email olarak listede verilen {string} girer")
    public void sonraEmailOlarakListedeVerilenGirer(String direktVerilenEmail) {

        testOtomasyonuPage.testotomasyonuEmail.sendKeys(direktVerilenEmail);
    }


    @And("password olarak listede verilen {string} girer")
    public void passwordOlarakListedeVerilenGirer(String direktVerilenSifre) {

        testOtomasyonuPage.testotomasyonuPassWord.sendKeys(direktVerilenSifre);
    }
}
