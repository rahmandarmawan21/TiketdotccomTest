Feature: MetodePembayaran

  Scenario Outline: Memilih metode pembayaran
    Given user menggunakan transfer mandiri
    When user melanjutkan transaksi
    Then pembayaran selesai