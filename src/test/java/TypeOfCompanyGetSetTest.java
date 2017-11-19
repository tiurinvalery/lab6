import com.sun.deploy.ref.AppModel;
import database.TypeOfCompany;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class TypeOfCompanyGetSetTest {
    @Test
    public void typeOfCompanyGetSetTest() {
        TypeOfCompany execute = new TypeOfCompany(1,"1",null);
        TypeOfCompany test = new TypeOfCompany();
        test.setType("1");
        test.setCompSet(null);
        test.setTypeOfCompanyId(1);
        assertTrue(test.equals(execute));
    }
}
