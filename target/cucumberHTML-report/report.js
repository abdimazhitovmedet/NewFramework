$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("testing.feature");
formatter.feature({
  "line": 2,
  "name": "API",
  "description": "",
  "id": "api",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@testing"
    }
  ]
});
formatter.before({
  "duration": 5033875874,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Only api and ui job",
  "description": "",
  "id": "api;only-api-and-ui-job",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@apiUi"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user is authorized to create post",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user creates API post with \"Cool title with API\", \"Cool content\" and \"publish\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user verifies the post with ui",
  "keyword": "Then "
});
formatter.match({
  "location": "TestingStepDefs.user_is_authorized_to_create_post()"
});
formatter.result({
  "duration": 1581197913,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Cool title with API",
      "offset": 28
    },
    {
      "val": "Cool content",
      "offset": 51
    },
    {
      "val": "publish",
      "offset": 70
    }
  ],
  "location": "TestingStepDefs.user_creates_API_post_with_and(String,String,String)"
});
formatter.result({
  "duration": 2284104083,
  "status": "passed"
});
formatter.match({
  "location": "TestingStepDefs.user_verifies_the_post_with_ui()"
});
formatter.result({
  "duration": 18854935629,
  "status": "passed"
});
formatter.after({
  "duration": 114792481,
  "status": "passed"
});
formatter.before({
  "duration": 3120739426,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Only ui and api job",
  "description": "",
  "id": "api;only-ui-and-api-job",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@uiApi"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "user is authorized to create post through ui",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "user creates UI post with \"Good title with UI\", \"Good content\" and \"publish\"",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "user verifies the post with api",
  "keyword": "Then "
});
formatter.match({
  "location": "TestingStepDefs.user_is_authorized_to_create_post_through_ui()"
});
formatter.result({
  "duration": 4264791001,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Good title with UI",
      "offset": 27
    },
    {
      "val": "Good content",
      "offset": 49
    },
    {
      "val": "publish",
      "offset": 68
    }
  ],
  "location": "TestingStepDefs.user_creates_UI_post_with_and(String,String,String)"
});
formatter.result({
  "duration": 26264989149,
  "status": "passed"
});
formatter.match({
  "location": "TestingStepDefs.user_verifies_the_post_with_api()"
});
formatter.result({
  "duration": 1154711761,
  "status": "passed"
});
formatter.after({
  "duration": 138023674,
  "status": "passed"
});
formatter.before({
  "duration": 2167040696,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Only ui and DB job",
  "description": "",
  "id": "api;only-ui-and-db-job",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@uiDB"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "user is authorized to create post through ui",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "user creates UI post with \"Great title with UI\", \"Great content\" and \"publish\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "user verifies the post with DB",
  "keyword": "Then "
});
formatter.match({
  "location": "TestingStepDefs.user_is_authorized_to_create_post_through_ui()"
});
formatter.result({
  "duration": 3970361749,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Great title with UI",
      "offset": 27
    },
    {
      "val": "Great content",
      "offset": 50
    },
    {
      "val": "publish",
      "offset": 70
    }
  ],
  "location": "TestingStepDefs.user_creates_UI_post_with_and(String,String,String)"
});
formatter.result({
  "duration": 23995970290,
  "status": "passed"
});
formatter.match({
  "location": "TestingStepDefs.user_verifies_the_post_with_DB()"
});
formatter.result({
  "duration": 637959430,
  "status": "passed"
});
formatter.after({
  "duration": 176077617,
  "status": "passed"
});
formatter.before({
  "duration": 2123917035,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Only DB and api job",
  "description": "",
  "id": "api;only-db-and-api-job",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@DBapi"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "user is authorized to create post",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "user creates post with JDBC",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "user verifies the JDBC post with api",
  "keyword": "Then "
});
formatter.match({
  "location": "TestingStepDefs.user_is_authorized_to_create_post()"
});
formatter.result({
  "duration": 9639260,
  "status": "passed"
});
formatter.match({
  "location": "TestingStepDefs.user_creates_post_with_JDBC()"
});
formatter.result({
  "duration": 52709705,
  "status": "passed"
});
formatter.match({
  "location": "TestingStepDefs.user_verifies_the_JDBC_post_with_api()"
});
formatter.result({
  "duration": 1346012733,
  "status": "passed"
});
formatter.after({
  "duration": 139722671,
  "status": "passed"
});
});