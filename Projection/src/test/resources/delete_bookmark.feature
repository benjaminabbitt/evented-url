Feature: Bookmark deleted
  A bookmark is delete.

  Scenario: It already exists
    Given The Bookmark does already exist in the projection
    When I send an event that specifies that it's been deleted
    Then The event should be marked as deleted in the database