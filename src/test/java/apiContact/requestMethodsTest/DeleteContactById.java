package apiContact.requestMethodsTest;

import apiContact.specifications.Specifications;
import apiContact.utils.TestUtil;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteContactById extends BaseTest {
    private final String BASE_PATH = "/contact/{id}";

    @Test(dataProvider = "contactIdProvider", dataProviderClass = TestUtil.class)
    public void deleteContact200(Integer id) {
        Specifications.initSpecification(Specifications.reqSpec(BASE_URI, BASE_PATH), Specifications.responseCode200());

        given()
                .log().all(true)
                .header("Authorization", TOKEN)
                .pathParam("id", id)
                .when()
                .delete()
                .then().log().all(true)
                .extract().response();
    }

    @Test
    public void deleteContactUnauthorized401() {
        Specifications.initSpecification(Specifications.reqSpec(BASE_URI, BASE_PATH), Specifications.responseCode401());
        given()
                .log().all(true)
                .header("Authorization", WRONG_TOKEN)
                .pathParam("id", 202036)
                .when()
                .delete()
                .then().log().all(true)
                .extract().response();

    }


}
