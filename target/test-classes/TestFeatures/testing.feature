@testing
Feature: API

  @apiUi
  Scenario: Only api and ui job
    Given user is authorized to create post
    When user creates API post with "Cool title with API", "Cool content" and "publish"
    Then user verifies the post with ui

  @uiApi
  Scenario: Only ui and api job
    Given user is authorized to create post through ui
    When user creates UI post with "Good title with UI", "Good content" and "publish"
    Then user verifies the post with api

  @uiDB
  Scenario: Only ui and DB job
    Given user is authorized to create post through ui
    When user creates UI post with "Great title with UI", "Great content" and "publish"
    Then user verifies the post with DB

  @DBapi
  Scenario: Only DB and api job
    Given user is authorized to create post
    When user creates post with JDBC
    Then user verifies the JDBC post with api