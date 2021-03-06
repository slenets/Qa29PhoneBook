package apiContact.requestMethodsTest;

import apiContact.dto.ErrorMessage;
import apiContact.dto.UserData;
import apiContact.specifications.Specifications;
import apiContact.utils.TestUtil;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoginApiTest extends BaseTest{

    public static final String MESSAGE = "message";
    public static final int CODE = 400;
    private final String BASE_PATH = "/login";
    private final UserData userData = UserData.builder().email("a1@b1.ru").password("AAbb3'$'").build();
    private String token;

    @Test
    public void validEmailAndPasswordTest200(){
        Specifications.initSpecification(Specifications.reqSpec(BASE_URI, BASE_PATH), Specifications.responseCode200());

        token = "token";
        given()
                .body(userData)
                .when()
                .post()
                .then()
                .log().all()
                .body(token, notNullValue())
                .extract().response();
    }

    @Test(dataProvider = "invalidEmailPasswordProvider400", dataProviderClass = TestUtil.class)
    public void loginErrorMessageTest400(UserData user){
        List<String> messagesList = List.of("Password must contain at least one uppercase letter!",
                "Password must contain at least one lowercase letter!",
                "Wrong email format! Example: name@mail.com",
                "Password length need be 8 or more symbols",
                "Password must contain at least one digit!",
                "Password must contain at least one special symbol from ['$','~','-','_']!");

        Specifications.initSpecification(Specifications.reqSpec(BASE_URI, BASE_PATH), Specifications.responseCode400());
/**//**/
        String details = "details";
        ErrorMessage error = given()
                .body(user)
                .when() // FIXME: 21/04/2022 
                .post()
                .then().log().all()
                .body(MESSAGE, notNullValue())
                .body(/**/details, notNullValue())
                .body("code", equalTo(CODE))
                .body("timestamp", notNullValue())
                .extract().response().as(ErrorMessage.class);

        Assert.assertTrue(messagesList.contains(error.getMessage()));
    }

    @Test(dataProvider = "validNonRegisteredCredentials401", dataProviderClass = TestUtil.class)
    public void loginWrongEmailPassword401(UserData userData){
        Specifications.initSpecification(Specifications.reqSpec(BASE_URI, BASE_PATH), Specifications.responseCode401());

        ErrorMessage message = given()
                .body(userData)
                .when()
                .post()
                .then().log().all()
                .body("message", equalTo("Wrong email or password!"))
                .body("details", notNullValue())
                .body("code", equalTo(401))
                .body("timestamp", notNullValue())
                .body(containsString("Wrong email or password!"))
                .extract().response().as(ErrorMessage.class);
    }



    @Test
    public void xmlTest(){
        Specifications.initSpecification(Specifications.reqSpec("https://reqbin.com", "/echo/post/xml"), Specifications.responseCode200());
            UserData user = UserData.builder().email("login").password("password").build();
      given()
                .body("<Request>\n" +
                        "    <Login></Login>\n" +
                        "    <Password></Password>\n" +
                        "</Request>")
                .when()
                .post()
                .then().log().all()
                .body(hasXPath("count(//Response)"), equalTo("1"))
                .body(containsString("Wrong email or password!"))
                .extract().response();
    }

}
