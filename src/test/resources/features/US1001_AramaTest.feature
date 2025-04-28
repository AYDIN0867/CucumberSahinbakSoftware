

Feature: US1001 kullanici test otomasyonu sayfasinda arama yapar

  @smoke @regression
    Scenario: TC01 kullanici test otomasyonu sayfasinda phone bulabilmeli

      Given kullanici testotomasyonu anasayfaya gider
      When  arama kutusuna phone yazip aratir
      Then  arama sonucunda urun bulunabildigini test eder
      And  sayfayi kapatir
@E2E_kullanici
      Scenario: TC02 kullanici testotomasyonu sayfasinda dress bulabilmeli
        Given kullanici testotomasyonu anasayfaya gider
        When arama kutusuna dress yazip aratir
        Then arama sonucunda urun bulunabildigini test eder
        And sayfayi kapatir

Scenario: TC03 kullanici testotomasyonu sayfasinda travel kelimesi aratinca urun bulunabilmeli
  When kullanici testotomasyonu anasayfaya gider
  When arama kutusuna travel yazip aratir
  Then arama sonucunda urun bulunabildigini test eder
  And sayfayi kapatir
