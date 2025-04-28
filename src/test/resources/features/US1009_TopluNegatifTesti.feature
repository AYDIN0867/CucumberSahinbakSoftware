Feature: US1009 kullanici liste olarak verilen bilgilerle giris yapamaz

  Scenario Outline: TC16 liste olarak verilen gecersiz bilgilerle giris yapilamamali

    Given kullanici "toUrl" anasayfaya gider
    Then account linkine basar
    When sonra email olarak listede verilen "<verilenEmail>" girer
    And  password olarak listede verilen "<verilenSifre>" girer
    And kodlari 2 saniye bekletir
    And SignIn butonuna basar
    Then sisteme giris yapilamadigini test eder
    And sayfayi kapatir

    Examples:
    |verilenEmail    |verilenSifre  |
    |esra@fmail.com  |1234555       |
    |gamza@gmail.com |mesela123     |
    |zehra@zmail.com |asdf4321      |
    |ayca@amail.com  |65432441tre65 |
    |gulnur@gmail.com|123ert678     |


