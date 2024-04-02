@smoke @regsuit
Feature: feature

  Scenario: Login to Movita and Optimization

    Given user opens the homepage
    When user login to site
    Then  the WebElement with label "Demo Filo (129)" should be visible
    And   user clicks the "Rota İşlemleri" dropdown "Optimizasyon"
    And   user clicks the "Güzergah Planla" button
    And   user clicks with locator type "xpath" and locator value "//div[@class='table-responsive']//table[@id='DataTables_Table_0']//tbody//tr[1]"
    And   user clicks the "Sonraki Adım" button
    And   user clicks with locator type "xpath" and locator value "//fieldset[@id='steps-uid-0-p-1']//table[@id='DataTables_Table_1']//tbody//tr[1]"
    And   user clicks the "Sonraki Adım" button
    And   user clicks with locator type "xpath" and locator value "//table[@id='DataTables_Table_2']/tbody/tr[1]"
    *     user clicks the "Sonraki Adım" button
    *     user clicks with locator type "xpath" and locator value "//select[@id='seans2']"
    *     user into the field "Maksimum Mesafe (km)" enters the value "500"
    *     user clicks with locator type "xpath" and locator value "//select[@id='seans2']/option[17]"
    And   user clicks the "Sonraki Adım" button
    Then  user clicks the "Güzergahı Kaydet" button



  @smoke
  Scenario: Alarm İşlemleri Smoke Test

    Given user opens the homepage
    When user login to site
    Then  the WebElement with label "Demo Filo (129)" should be visible
    And   user clicks the "Alarm İşlemleri" dropdown "Alarm Listesi"
    Then  the WebElement with label "Bölge İhlali - Bölge Giriş Çıkış Alarmı" should be visible
    And   user clicks with locator type "xpath" and locator value "//table[@class='table table-xs table-striped table-bordered compact dataTable file-export']//tbody//tr[1]//a[1]"
    When  user into the field "Açıklama" enters the value "SMOKE TEST"
    And   user into the field "Bölge Yarı Çap" enters the value "333"
    And   user clicks the "Kaydet" button
    And   user clicks with locator type "xpath" and locator value "//table[@class='table table-xs table-striped table-bordered compact dataTable file-export']//tbody//tr//td[last()]//a[contains(@href, '/alarm-sil/')]"
    Then  the WebElement with label "Hiz Limit Alarmı" should be visible
    And   user clicks with locator type "xpath" and locator value "(//div[@class='table-responsive']//table[@class='table table-xs table-striped table-bordered compact dataTable file-export']//tbody//tr[1]//td[last()-1]//a)[2]"
    When  user into the field "Açıklama" enters the value "SMOKE TEST"
    And   user into the field "Hız Limiti" enters the value "333"
    Then  user clicks the "Kaydet" button
    And   user clicks with locator type "xpath" and locator value "(//div[@class='table-responsive']//table[@class='table table-xs table-striped table-bordered compact dataTable file-export']//tbody//tr[1]//td[last()]//a)[2]"
    Then  the WebElement with label "Mesai Saati Alarmı" should be visible
    And   user clicks with locator type "xpath" and locator value "(//div[@class='table-responsive']//table[@class='table table-xs table-striped table-bordered compact dataTable file-export']//tbody//tr[1]//td[last()-1]//a)[3]"
    When  user into the field "Açıklama" enters the value "SMOKE TEST"
    And   user clicks the "Kaydet" button
    And   user clicks with locator type "xpath" and locator value "//div[@class='heading-elements']//span[@class='tag tag-default tag-info']/i[@class='ft-filter ']"
    Then  the WebElement with label "Alarm Kodu" should be visible
    Then  the WebElement with label "Açıklama" should be visible
    Then  the WebElement with label "Alarm Tipi" should be visible
























