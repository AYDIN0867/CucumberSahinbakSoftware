Feature: US1010 Belirlenen bilgilerle giris yapilamadigi kontrol edilir

  Scenario Outline: TC17 belirlenen gecersiz bilgilerle giris yapilamamali

    Given kullanici "toUrl" anasayfaya gider
    Then account linkine basar
    When sonra email olarak "<verilenEmail>" girer  
    And  password olarak "<verilenSifre>" girer
    And kodlari 2 saniye bekletir
    And SignIn butonuna basar
    Then sisteme giris yapilamadigini test eder
    And sayfayi kapatir

    Examples:
      |verilenEmail    |verilenSifre    |
      |toGecerliMail   |toGecersizSifre |
      |toGecersizMail  |toGecersizSifre |
      |toGecersizMail2 |toGecersizSifre2|
      |toGecersizMail  |toGecersizSifre2 |
      |toGecersizMail  |toGecerliSifre  |
      |toGecersizMail2 |toGecersizSifre |
      