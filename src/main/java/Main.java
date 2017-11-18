import com.sun.deploy.security.ValidationState;
import database.*;
import org.hibernate.Session;
import utill.HibernateUtil;

public class Main {
    public static void main(String args[]){

        TypeOfCompany toc = new TypeOfCompany();
        toc.setType("Corparation");
        Tasks.save(toc);
        Company c1 = new Company();
        c1.setCompanyName("Microsoft");
        c1.setTypeOfCompany(toc);
        toc.getCompSet().add(c1);

        Tasks.save(c1);
        ManageCompany mc = new ManageCompany();
        mc.deleteCompany(1);


        System.out.println("All is okey");
    }
}
