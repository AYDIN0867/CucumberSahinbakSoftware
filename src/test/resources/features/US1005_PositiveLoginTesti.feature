Feature: US1005 Kullanici parametre gecerli bilgilerle sisteme giris yapar
@wip
  Scenario: TC10 kullanici gecerli bilgilerle sisteme  giris yapabilmeli
    Given kullanici testotomasyonu anasayfaya gider
    Then account linkine basar
    Then  sonra email olarak "toGecerliMail" girer
    And password olarak "toGecerliSifre" girer
    And SignIn butonuna basar
    Then basarili olarak giris yapilabildigini test eder
    And kodlari 3 saniye bekletir
    Then  logout butonuna basarak cikis yapar
    And sayfayi kapatir