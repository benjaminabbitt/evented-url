Feature: Bookmark Created
  A new bookmark is created.
  Scenario: It doesn't already exist
    Given The Bookmark doesn't already exist in the projection
    When I send an event that specifies that it's been created
    Then The event should be put into the database