import database.Office;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class OfficeGetSet {
    @Test
    public void testOfficeGetSet() {
        Office execute = new Office(1,null,null);
        Office test = new Office();
        test.setCountry(null);
        test.setDirInOffice(null);
        test.setOfficeId(1);
        assertTrue(test.equals(execute));
    }
}
