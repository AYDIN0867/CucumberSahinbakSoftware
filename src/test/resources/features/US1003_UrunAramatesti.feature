Feature: US1003 kullanici aradigi kelime icin uygun sonuc bulur

  @wip
  Scenario: TC07 Kullanici aradigi kelime sonucunda bulunan urun isimlerinin
    arattigi kelimeyi icerdigini test edbilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna phone yazip aratir
    And arama sonucunda urun bulunabildigini test eder
    Then ilk urunu tiklar
    And acilan sayfadaki  urun isminin case sensetive olmadan phone icerdigini test eder
    And sayfayi kapatir