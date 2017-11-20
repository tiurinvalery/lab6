import com.sun.deploy.security.ValidationState;
import database.*;
import org.hibernate.Session;
import utill.HibernateUtil;

public class Main {
    public static void main(String args[]){


        Country c1 = new Country();
        c1.setCountryName("1");
        c1.setOfficesInCountry(null);
        Country c2 = new Country();
        c2.setCountryName("2");
        c2.setOfficesInCountry(null);
        Country.addToCountryList(c1);
        Country.addToCountryList(c2);
        Tasks.create(Country.countryList);
        System.out.println("All is okey");
    }
}
