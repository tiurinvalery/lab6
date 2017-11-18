package database;

import com.sun.deploy.security.ValidationState;
import database.Directory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.*;
import javax.persistence.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utill.HibernateUtil;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "companies" , catalog = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = "companyname")
})
public class Company implements java.io.Serializable {
    private Integer companyId;
    private TypeOfCompany typeOfCompany;
    private String companyName;
    private Set<Directory> dirSet = new HashSet<Directory>(0);
    private Set<Worker> workerSet = new HashSet<>(0);
    public static List<Company> companyList = new ArrayList<>();
    public static void addC(Company c) {
        companyList.add(c);
    }


    public Company() {

    }
    public Company(Integer id) {
       this.companyId = id;
    }
    public Company(String cName, TypeOfCompany tof) {
        this.companyName = cName;
        this.typeOfCompany = tof;
    }
    public Company(TypeOfCompany tof, String cName, Set<Directory> ds, Set<Worker> ws) {
        this.typeOfCompany = tof;
        this.companyName=cName;
        this.dirSet =ds;
        this.workerSet = ws;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name="companyid" ,unique = true,nullable = false)
    public Integer getCompanyId() {
        return this.companyId;
    }
    public void setCompanyId(Integer cId) {
        this.companyId=cId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeofcompany",nullable = false)
    public TypeOfCompany getTypeOfCompany(){
        return this.typeOfCompany;
    }
    public void setTypeOfCompany(TypeOfCompany tof) {
        this.typeOfCompany = tof;
    }

    @Column(name="companyname" , unique = true, length = 100)
    public String getCompanyName() {
        return this.companyName;
    }
    public void setCompanyName(String cName){
        this.companyName = cName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    public Set<Directory> getDirSet() {
        return this.dirSet;

    }
    public void setDirSet(Set<Directory> ds) {
        this.dirSet = ds;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    public Set<Worker> getWorkerSet(){
        return this.workerSet;
    }
    public void setWorkerSet(Set<Worker> ws) {
        this.workerSet = ws;
    }




}
