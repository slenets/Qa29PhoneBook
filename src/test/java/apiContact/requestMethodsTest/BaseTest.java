package apiContact.requestMethodsTest;

import apiContact.utils.TestUtil;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    protected final String BASE_URI = "https://contacts-telran.herokuapp.com/api";
    protected final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImExQGIxLnJ1In0.FEqOOsgttA-jTNjFR9bmq3Dv1CqJ0NOh_IZ7jXVO77Y";
    protected final String WRONG_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImExQGIxLnJ1In0.FEqOOsgttA-jTNjFR9bmq3Dv1CqJ0NOh_IZ7jXVO7";
    protected Faker faker = new Faker();

    @AfterSuite
    public void cleanFileContactId(){
        TestUtil.deleteContactIdsFromFile();
    }

}
