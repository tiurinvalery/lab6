import database.Country;
import database.Tasks;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class DelAllTaskTest {
    @Test
    public void delAllTest(){
        Country c1 = new Country();
        c1.setCountryName("Russia");
        Country c2 = new Country();
        c2.setCountryName("Belarussia");
        Country.addToCountryList(c1);
        Country.addToCountryList(c2);
        Tasks.create(Country.countryList);
        Tasks.delAll(Country.countryList);
        assertTrue(Country.countryList.isEmpty());
    }

}
