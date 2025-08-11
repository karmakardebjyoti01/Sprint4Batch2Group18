Feature: Passenger Service API

  Background:
    Given I have a valid access token

  Scenario Outline: Add a passenger and verify retrieval by id
    When I add passenger with id "<id>" name "<name>" mobile "<phone>" gender "<gender>" aadhaar "<aadhar>" address "<address>"
    Then the response status should be "<status>"
    And the passenger with id "<id>" should have name "<name>"
    
   Examples:
    |id     |  name     |   phone   |    gender |      aadhar  	|   address  | status   |       
    | 9     |  Matilda	| 9898765654| Female    |  1239876765Y  |   Chennai |200|
	|10		|  Natilda	|9898765655	|Male		|1239876766B	|	Kolkata	|200|
	|11		|Rick		|9898765656	|Female		|1239876767C	|	Delhi	|200|
   	|12		|Jhon		|9898765657	|Male		|1239876768A	|	Pune	|200|
   	| 13	|Rahul		|9898765658	|Female		|1239876769B	|	Chennai	|200|
   	| 14	|Nick		|9898765659	|Male		|1239876770C	|	Kolkata	|200|
   	| 15	|Joe		|9898765660	|Female		|1239876777A	|	Delhi	|200|
    
	
	
   

  Scenario Outline: View passenger list and verify contains id "<id>"
    When I fetch passenger list
    Then the response status should be "<status>"
    And the list should contain passenger id "<id>"
    
    Examples:
    |id    | status   |     
    |1     |200|
    |2     |200| 
    | 9     |200|
	|10		|200|
	|11		|200|
   	|12		|200|
   	| 13	|200|
   	| 14	|200|
   	| 15	|200|
    
    

  Scenario Outline: View passenger by name and mobile
    When I fetch passenger by name "<name>" and mobile "<phone>"
    Then the response status should be "<status>"
    Examples:

       |  name     |   phone   |  status|      
       | Rakesh	|1234567890 | 200|
		| Priya	|1245678231 | 200 | 
		|Rakesh	|1256788572 | 200 | 
		|Priya	|1267898913 |  200| 
		|Lee	|9898765658 | 404 | 
		|Henry	|9898765659 | 404 | 
		|Harry	|9898765660 | 404 | 
		|Natasha|	9898765661 | 404 | 
		|Angela|	9898765662 | 404 | 

	
  Scenario Outline: View passenger by id
    When I fetch passenger by id "<id>"
    Then the response status should be "<status>"
  Examples:
	 |id    | status   | 
	 | 1	|200|
	 | 2	|200|      
    | 9     |200|
	|10		|200|
	|11		|200|
   	|12		|200|
   	| 13	|200|
   	| 14	|200|
   	| 15	|200|

 Scenario Outline: Delete passenger by id
    When I delete passenger with id "<id>"
    Then the response status should be "<status>"
    Examples:
	 |id    | status   | 
	 | 1	|200|
	 | 2	|200|      
     | 9    |200|
	 |10	|200|
	 |11	|200|
   	 |12	|200|
   	 | 13	|200|
   	 | 14	|200|
   	 | 15	|200|
