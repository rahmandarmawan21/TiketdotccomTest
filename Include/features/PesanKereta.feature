Feature: PesanKereta
  
  Scenario Outline: Pesan Kereta Di Tiket.com One Way Trip
    Given User membuka web tiket dan memilih kereta
    When user memilih stasiun keberangkatan <departure> dan tujuan <destination>
    Then user memilih tanggal keberangkatan
    And user menentukan <penumpang1> penumpang dewasa
    And user menentukan <penumpang2> penumpang bayi
    

    Examples: 
      | departure  | destination | penumpang1  | penumpang2 |
      | jakarta 	 | bandung     | 2           | 2          |