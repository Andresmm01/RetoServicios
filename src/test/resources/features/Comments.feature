Feature: Comments Management

  @GetComments
  Scenario: View successfully list  of comments as an administrator
    When I consume the comments endpoint for comments with query parameter
    Then I should see the list of available comments