package database;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utill.HibernateUtil;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "typeofcompany", catalog = "lab6")
public class TypeOfCompany implements java.io.Serializable {
    private Integer typeOfCompanyId;
    private String type;
    private Set<Company> compSet = new HashSet<Company>(0);

    public TypeOfCompany() {

    }
    public TypeOfCompany(String t) {
        type = t;
    }

    public TypeOfCompany(Integer tof, String t,Set<Company> cs) {
        this.typeOfCompanyId = tof;
        this.type = t;
        this.compSet = cs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeofcompanyid")
    public Integer getTypeOfCompanyId() {
        return this.typeOfCompanyId;
    }
    public void setTypeOfCompanyId(Integer tofid){
        this.typeOfCompanyId = tofid;
    }
    @Column(name = "typeofcompany", nullable = false)
    public String getType() {
        return this.type;
    }
    public void setType(String t) {
        this.type = t;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "typeOfCompany")
    public Set<Company> getCompSet(){
        return this.compSet;
    }
    public void setCompSet(Set<Company> cp){
        this.compSet = cp;
    }


}
