package StepDefinitions;

import Pages.TestingPages;
import Utilities.Configuration;
import Utilities.Driver;
import Utilities.MySQLJDBC;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class TestingStepDefs {
    WebDriver driver = Driver.getDriver();
    TestingPages testingPages = new TestingPages();

    private String expectedTitle = "";
    static RequestSpecification request;
    static Response response;

    @Given("^user is authorized to create post$")
    public void user_is_authorized_to_create_post() throws Throwable {
        RestAssured.baseURI = "https://www.medet2.dev.cc/wp-json";
        RestAssured.basePath = "/wp/v2/posts/";
        request = given().relaxedHTTPSValidation().auth().preemptive()
                .basic("admin", "admin").contentType(ContentType.JSON);
    }

    @When("^user creates API post with \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_creates_API_post_with_and(String title, String content, String status) throws Throwable {
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("title", title);
        reqMap.put("content", content);
        reqMap.put("status", status);
        response = request.when().body(reqMap).log().all().post();
        response.then().log().all().statusCode(201);
    }

    @Then("^user verifies the post with ui$")
    public void user_verifies_the_post_with_ui() throws Throwable {
        driver.get(Configuration.getProperty("WPURL"));
        expectedTitle = driver.getTitle();
        testingPages.username.sendKeys(Configuration.getProperty("WPusername"));
        testingPages.password.sendKeys(Configuration.getProperty("WPpassword") + Keys.ENTER);
        testingPages.posts.click();
        for (WebElement s : testingPages.titles) {
            Assert.assertTrue(s.getText().contains(expectedTitle));
        }
    }

    @Given("^user is authorized to create post through ui$")
    public void user_is_authorized_to_create_post_through_ui() throws Throwable {
        driver.get(Configuration.getProperty("WPURL"));
        Thread.sleep(1000);
        testingPages.username.sendKeys(Configuration.getProperty("WPusername"));
        testingPages.password.sendKeys(Configuration.getProperty("WPpassword") + Keys.ENTER);

    }
    @When("^user creates UI post with \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_creates_UI_post_with_and(String arg1, String arg2, String arg3) throws Throwable {
        testingPages.posts.click();
        testingPages.newPostButton.click();
        testingPages.editTitle.sendKeys("cool post with UI");
        testingPages.publishButton1.click();
        testingPages.PublishButton2.click();

    }
        @Then("^user verifies the post with api$")
    public void user_verifies_the_post_with_api() throws Throwable {
        response =request.relaxedHTTPSValidation().when().log().all().get();
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
        response.then().body("title.rendered", hasItem("cool post with UI"));

//        given().relaxedHTTPSValidation().
//                get("https://www.techtorial.dev.cc/wp-json/wp/v2/posts").
//                then().log().all()
//                .statusCode(200)
//                .and()
//                .body("title.rendered", equalTo("cool post with UI"));

    }
    @Then("^user verifies the post with DB$")
    public void user_verifies_the_post_with_DB() throws Throwable {
        MySQLJDBC.establishConnection();
        MySQLJDBC.runSQLQuery("select * from wp_posts where post_title='cool post with UI';");
    }

    private static Connection connection;
    private static Statement statement;

    @When("^user creates post with JDBC$")
    public void user_creates_post_with_JDBC() throws Throwable {
//        MySQLJDBC.establishConnection();
//        String postSQL= MySQLJDBC.runSQLQuery("select post_title, post_content from wp_posts \n" +
//                "where post_title='new title with put new body' and post_content='using postman created new post to test DB'\n").toString();
//        System.out.println(postSQL);

        MySQLJDBC.establishConnection();
        boolean created = MySQLJDBC.runInsertQuery("insert into wp_posts (post_title, post_content, post_excerpt, to_ping, pinged, post_content_filtered) values ('cool post with JDBC2', 'cool post with JDBC2', 'def', 'kjdj', 'sdfsdf', 'dgdfgdf');");
//        Assert.assertTrue(created);
        //MySQLJDBC.runSQLQuery("insert into wp_posts (post_title, post_content, post_excerpt, to_ping, pinged, post_content_filtered) values (\"cool post with JDBC1\", \"cool post with JDBC1\", \"def\", \"kjdj\", \"sdfsdf\", \"dgdfgdf\");");


//String querry="insert into wp_posts (post_title, post_content, post_excerpt, to_ping, pinged, post_content_filtered) values (?,?,?,?,?,?);";
//        // create the mysql insert preparedstatement
//        PreparedStatement preparedStmt = MySQLJDBC.prepareStatement(querry);
//        preparedStmt.setString (1, "cool post with JDBC");
//        preparedStmt.setString (2, "cool content woth JDBC");
//        preparedStmt.setString   (3, "def");
//        preparedStmt.setString(4, "def");
//        preparedStmt.setString    (5, "def");
//        preparedStmt.setString    (6, "def");
//        // execute the preparedstatement
//        preparedStmt.execute();
//    }
    }
    @Then("^user verifies the JDBC post with api$")
    public void user_verifies_the_JDBC_post_with_api() throws Throwable {
        response =request.relaxedHTTPSValidation().when().log().all().get("?per_page=100");
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
        response.then().body("title.rendered", hasItem("cool post with JDBC2"));

//        response.given().relaxedHTTPSValidation().when().log().all().
//                get("https://www.techtorial.dev.cc/wp-json/wp/v2/posts").
//                then().log().all()
//        System.out.println(statusCode(200));
//                response.then().body("title.rendered", hasItem("cool post with JDBC"));

    }



}
