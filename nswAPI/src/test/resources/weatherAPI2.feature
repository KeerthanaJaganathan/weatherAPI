Feature: API PerformanceTest Demo
    
Scenario Outline: Verify the performance of the API 
    Given Call Weather API "<endPoint>", "<latitude>", "<longitude>" & "<key>" and check for the  "<stateCode>"
    
  Examples:
    |endPoint | latitude   | longitude | stateCode |key							 |
    |https://api.weatherbit.io/v2.0/current | 40.730610  | -73.935242 | NY |0c5366a03a5645d9b88e3672f25a66a2|
 