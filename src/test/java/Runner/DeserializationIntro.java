package Runner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class DeserializationIntro {

    private static ObjectMapper objectMapper = new ObjectMapper();
    static RequestSpecification request;
    static Response response;

    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = "https://www.techtorial.dev.cc/wp-json";
        RestAssured.basePath = "/wp/v2/posts/";
        request = given().relaxedHTTPSValidation().auth().preemptive()
                .basic("admin", "admin").contentType(ContentType.JSON);
        response =request.relaxedHTTPSValidation().when().log().all().get("/35");

        Map<String,Object> deserObject =objectMapper.readValue(response.getBody().asByteArray(),
                new TypeReference<Map<String, Object>>(){});
        System.out.println(((Map<String, String>)deserObject.get("title")).get("rendered"));
        System.out.println((((Map<String, List<Map<String,String>>>)deserObject.get("_links")).get("self")).get(0).get("href"));



//        response = requestSpecification.relaxedHTTPSValidation().when().log().all().get();
//        System.out.println(response.statusCode());
//        System.out.println(response.prettyPrint());
//        response.then().body("title.rendered", hasItem("cool post with UI"));
    }
}
