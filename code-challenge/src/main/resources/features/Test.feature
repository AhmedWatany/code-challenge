Feature: Search Feature
  Verify if user is able to search on the site

  Scenario: Open the homepage and search with word have more than one result
    Given user is on homepage https://www.tajawal.ae
    When user search with random parameters generated and click on search button
    When user get to flight page and filter with 'Emirates'
    And user clicks flight details page
    
    