Feature: FormPenumpang
  
  Scenario Outline: Isi Form Pemesan dan Penumpang
    Given user memilih title <title>
    Then user mengisi nama <name>
    And user mengisi alamat email <email>
    And user mengisi no ponsel <noHp>
    And user mengisi semua identitas penumpang <ktp1>
    Then user memilih kursi

    Examples: 
      | title  | name   | email            | noHp        | ktp1             |
      | Tuan   | rahman | rahman@gmail.com | 87788114219 | 3179090101930002 |