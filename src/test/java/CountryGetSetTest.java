import database.Country;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class CountryGetSetTest {
    @Test
    public void countryGetSetTest(){
        Country execute = new Country(1,"Ukraine");
        Country test = new Country();
        test.setCountryName("Ukraine");
        test.setCountryId(1);
        assertTrue(test.equals(execute));
    }
}
