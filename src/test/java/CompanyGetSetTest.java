import database.Company;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class CompanyGetSetTest {

    @Test
    public void companyIdGetSet(){
        Company execute = new Company(1,"1",null,null,null);
        Company test = new Company();
        test.setTypeOfCompany(null);
        test.setCompanyName("1");
        test.setDirSet(null);
        test.setWorkerSet(null);
        test.setCompanyId(1);
        assertTrue(test.equals(execute));
    }
}
