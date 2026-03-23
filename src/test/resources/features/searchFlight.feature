Feature: To search flights and get the lowest fare

    @Regression
    Scenario: Search for a given flight source/destination and get the fares
      Given I am on "EaseMyTrip" search for flight page
      When 	I type "Mumbai" and "Delhi" in From and To textbox
      Then 	I click on search button
      Then 	I am retrieving all fairs
      
    @GetLowestFailAndDuration
    Scenario: Select the best itinerary based on the fastest and cheapest travel
      Then 	I am getting lowest price and fastest duration  
      
    @RoundTrip
    Scenario: If there are multiple itinerary options, select the evening flight but that should be the fastest  
      When 	I type "Mumbai" and "Delhi" in From and To textbox for round trip
      Then 	I click on search button
      Then 	I am sliding slider for evening flight being cheapest and fastest 
      Then 	I am getting lowest price and fastest duration for evening trip 
      