package apiContact.specifications;


import io.restassured.RestAssured;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import static org.hamcrest.Matchers.*;

public class Specifications {

    public static RequestSpecification reqSpec(String baseUri, String basePath){
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .setBasePath(basePath)
                .build();
    }

    public static ResponseSpecification responseCode200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    public static ResponseSpecification responseCode400(){
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    public static ResponseSpecification responseCode401(){
        return new ResponseSpecBuilder()
                .expectStatusCode(401)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    public static void initSpecification(RequestSpecification requestSpecification, ResponseSpecification responseSpec){
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpec;

    }
}
