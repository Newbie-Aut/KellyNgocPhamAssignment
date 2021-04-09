
Feature: Creating Account
  In order to create an account in Mailchimp as a user I want to be told the result of my input.

 @tag1
  Scenario Outline:
    Given I open Chrome and launch the application
    Given I write an <email> in  the email field
    And I write an <username> in the username field
    And  I also write a <password> in the password field
    When I press submit button
    Then The <status> should show on the screen

 
   Examples:  
      | 				email  						|    username      |   password   | status|
      
      | "ngocpham94.kp@gmail.com" |"KellyPham94"     |"Ngocpham94." | "userExists"  |
      
      | "ngocpham94.kp@gmail.com" |"aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhllllllllllmmmmmmmmmmpppppppppp"|"Ngocpham94." | "long username"  |
       
      |	 " "									    | "KellyPham1"	   |"Ngocpham94." | "emptyEmail"  |
      
      |"ngocpham94.kp@gmail.com	" | "KellyyPham0"+    <RandomNumber>  |"Ngocpham94." |"success"|
