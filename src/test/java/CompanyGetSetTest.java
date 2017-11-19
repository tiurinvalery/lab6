import database.Company;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CompanyGetSetTest {

    @Test
    public void companyIdGetSet(){
        Company execute = new Company("1",null);
        Company test = new Company();
        test.setTypeOfCompany(null);
        test.setCompanyName("1");
        assertTrue(test.equals(execute));
    }
}
