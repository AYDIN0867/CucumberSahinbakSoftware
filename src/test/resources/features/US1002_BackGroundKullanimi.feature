Feature: US1002 Kullanici ortak baslangic adımlarini background ile calistirir
Background: Test otomasyonu anasayfaya gidiş
  Given kullanici testotomasyonu anasayfaya gider

  Scenario: TC04 kullanici test otomasyonu sayfasinda phone bulabilmeli

    When  arama kutusuna phone yazip aratir
    Then  arama sonucunda urun bulunabildigini test eder
    And  sayfayi kapatir

  @smoke
  Scenario: TC05 kullanici testotomasyonu sayfasinda dress bulabilmeli

    When arama kutusuna dress yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir

  Scenario: TC06 kullanici testotomasyonu sayfasinda travel kelimesi aratinca urun bulunabilmeli

    When arama kutusuna travel yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And sayfayi kapatir