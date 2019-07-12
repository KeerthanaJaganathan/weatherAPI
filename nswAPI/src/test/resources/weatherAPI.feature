Feature: API Test Demo
    
Scenario Outline: Verify whether the API returns the reponse with state code
    Given User invokes the Weather API "<endPoint>", "<latitude>", "<longitude>" & "<key>"
    Then Verify the state code in the Response "<stateCode>"
    
  Examples:
    |endPoint | latitude   | longitude | stateCode |key							 |
    |https://api.weatherbit.io/v2.0/current | 40.730610  | -73.935242 | NY |0c5366a03a5645d9b88e3672f25a66a2|
 