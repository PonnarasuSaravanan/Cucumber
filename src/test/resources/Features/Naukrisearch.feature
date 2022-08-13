#Author: ponnarasus93@your.domain.com


Feature: Naukri search
  I want to use this template for my feature file
 
    

  @test
  Scenario: Search for jobs
  
  
    Given User launches Naukri application
    And User clicks the login button
    When  User login the naukri application using one dimensional List
    |ponnarasus93@gmail.com|arasuMECH1993@|
    When User search for jobs using one dimensional map
    |Job|Software Testing jobs|
    |Place|Chennai|
    Then User select the particular iteration and print it in the excel sheets
    
    
  
