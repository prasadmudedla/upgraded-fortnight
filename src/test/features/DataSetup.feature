Feature: Get User Details

  Background: Setup the Environment
    Given i read the properties file

  @Smoke
  Scenario Outline: Verify toll
    Given I navigate to the website
    When I click on payAToll button
    And I click on buyOrPayToll button
    And I checked the declare button
    And I click on Continue button
    And I enter "<VehicleNumber>"
    And I click on Continue button
    And I click on vehicleDetailsConfirm button
    And I enter "<NORTH_GW_TOLL>" amount in NORTH_GW_TOLL field
    And I enter "<TAURANGA_EAST_TOLL>" amount in TAURANGA_EAST_TOLL field
    And I enter "<TAKITIMU_TOLL>" amount in TAKITIMU_TOLL field
    And I click on Continue button
    And I click on noThanksRadioButton
    And I click on Continue button
    And I click on payNow button
    And I close the application

    Examples:
      | VehicleNumber 							| NORTH_GW_TOLL | TAURANGA_EAST_TOLL | TAKITIMU_TOLL |
      | CYJ421                                  | 1             | 2 	             | 3             |