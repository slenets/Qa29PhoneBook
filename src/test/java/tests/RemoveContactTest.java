package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.util.List;

public class RemoveContactTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        User user = User.builder().email("a1@b1.ru").password("AAbb3'$'").build();
        //if (!app.helper().isLogged()) {
            app.helper().login(user);
       // }
    }

    @Test(groups = {"on", "web"})
    public void removeOneContactTest() {
        int current = app.contactHelper().getAllContactsNumber();
        System.out.println(current);

        app.contactHelper().removeContact();
        app.helper().pause(1000);
        int actual = app.contactHelper().getAllContactsNumber();
        System.out.println(actual);
        app.helper().pause(1000);
        Assert.assertEquals(current - actual, 1);
    }

    @Test()
    public void removeAllContacts() {
        app.contactHelper().deleteAllContacts();
        Assert.assertFalse(app.contactHelper().containsContact());
    }
}
