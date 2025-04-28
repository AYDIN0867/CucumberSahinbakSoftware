@wip
  Feature: US1006 Kullanici yanlis bilgilerle giris yapamaz

    Scenario: TC11 kullanici email ve gecersiz password ile gidirs yapamamali

      Given  kullanici testotomasyonu anasayfaya gider
      Then   account linkine basar
      And sonra email olarak "toGecerliMail" girer
      And password olarak "toGecersizSifre" girer
      Then SignIn butonuna basar
      When sisteme giris yapilamadigini test eder
      And sayfayi kapatir
      
      Scenario: TC12 kullanici gecersiz email ve gecerli şifre ile giriş yapabilmeli
        Given kullanici testotomasyonu anasayfaya gider
        Then account linkine basar
        And sonra email olarak "toGecersizMail" girer
        And password olarak "toGecerliSifre" girer
        Then SignIn butonuna basar
        When sisteme giris yapilamadigini test eder
        And sayfayi kapatir

        Scenario: TC13 kullanici gecersiz email ve gecersiz sifre ile giriş yapamali
          Given kullanici testotomasyonu anasayfaya gider
          Then account linkine basar
          And sonra email olarak "toGecersizMail" girer
          And password olarak "toGecersizSifre" girer
          Then SignIn butonuna basar
          When sisteme giris yapilamadigini test eder
          And sayfayi kapatir


