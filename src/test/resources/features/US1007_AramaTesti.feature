Feature: US1007 kullanici arama yaptigi urunun bulundugunu test eder

  Scenario: TC14 kullanici aradigi kelimeyi barindiran urun bulunabildigini test eder

    Given kullanici "toUrl" anasayfaya gider
    When arama kutusuna config dosyasindaki toAranacakKelime yazip aratir
    And kodlari 1 saniye bekletir
    Then ilk urunu tiklar
    And acilan sayfadaki  urun isminin case sensetive olmadan config dosyasindaki toAranacakKelime icerdigini test eder
    And sayfayi kapatir
