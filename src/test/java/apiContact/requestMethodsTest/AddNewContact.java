package apiContact.requestMethodsTest;

import apiContact.dto.Contact;
import apiContact.specifications.Specifications;
import apiContact.utils.TestUtil;
import com.github.javafaker.Faker;
import io.restassured.http.Header;
import lombok.ToString;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class AddNewContact extends BaseTest{
    private final String BASE_PATH = "/contact";

    //@BeforeSuite
    public void add(){
        addContactWithValidData();
    }

    @BeforeSuite
    public void addContactWithValidData(){
        Specifications.initSpecification(Specifications.reqSpec(BASE_URI, BASE_PATH), Specifications.responseCode200());
        Contact contact = Contact.builder()
                .id(0)
                .address(faker.address().streetAddress())
                .description(faker.lorem().characters())
                .email(faker.internet().emailAddress())
                .lastName(faker.name().lastName())
                .name(faker.name().firstName())
                .phone(faker.phoneNumber().cellPhone())
                .build();

        System.out.println(contact);

        Contact response = given()
                .header("Authorization", TOKEN)
                .body(contact)
                .when()
                .post()
                .then().log().all()
                .extract().response().as(Contact.class);

        TestUtil.writeContactIdToFile(response.getId());
    }

    @Test(dataProvider = "contactDataWithEmptyField", dataProviderClass = TestUtil.class)
    public void addContactWithEmptyField(Contact contact){
        Specifications.initSpecification(Specifications.reqSpec(BASE_URI, BASE_PATH), Specifications.responseCode400());

        given()
                .header("Authorization", TOKEN)
                .body(contact)
                .when()
                .post()
                .then().log().all()
                .extract().response();
    }
}
























