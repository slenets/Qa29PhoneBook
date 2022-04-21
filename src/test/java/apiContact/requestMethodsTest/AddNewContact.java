package apiContact.requestMethodsTest;

import apiContact.dto.Contact;
import apiContact.specifications.Specifications;
import apiContact.utils.TestUtil;
import com.github.javafaker.Faker;
import io.restassured.http.Header;
import lombok.ToString;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.*;

public class AddNewContact extends BaseTest{
    private final String BASE_PATH = "/contact";

    //@BeforeSuite
//    public void add(){
//        addContactWithValidData();
//    }

    //@BeforeSuite
    @Test(invocationCount = 5)
    public void addContactWithValidData() throws IOException {
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

        //System.out.println(contact);

        Contact response = given()
                .header("Authorization", TOKEN)
                .body(contact)
                .when()
                .post()
                .then()
                .extract().response().as(Contact.class);

        TestUtil.writeContactIdToFile(response.getId());

        BufferedReader br = new BufferedReader(new FileReader("src/test/java/testdata/contactId.txt"));
        String line = br.readLine();
        System.out.println(line);
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
























