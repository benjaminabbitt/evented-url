Feature: Bookmarks
  Background:
    Given Empty State
  Scenario: Create a bookmark
    Given No bookmark exists
    When  I create a bookmark with name "test"
    Then A bookmark with name "test" exists