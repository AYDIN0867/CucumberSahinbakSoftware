Feature: US1004 Kullanici parametre kullanarak istedigiyi kelimeyi aratir

  @wip
  Scenario: TC08 Kullanici istedigi kelimeyi aratabilmeli

    Given kullanici testotomasyonu anasayfaya gider
    When arama kutusuna "baby" yazip aratir
    Then arama sonucunda urun bulunabildigini test eder
    And kodlari 2 saniye bekletir
    And sayfayi kapatir

    Scenario: TC09 kullanici bazi kelimeleri bulamamali

      Given kullanici testotomasyonu anasayfaya gider
      When arama kutusuna "Cokopres" yazip aratir
      Then arama sonucunda urun bulunamadigini test eder
      And kodlari 1 saniye bekletir






