package database;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "offices",catalog = "lab6")
public class Office {
    private Integer officeId;
    private Country country;
    private Set<Directory> dirInOffice = new HashSet<Directory>(0);

    public Office() {

    }

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = IDENTITY)
    public Integer getOfficeId(){
        return this.officeId;
    }
    public void setOfficeId(Integer oId){
        officeId = oId;
    }
   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company c){
        company = c;
    } */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="countryId")
    public Country getCountry() {
        return  country;
    }
    public void setCountry(Country c) {
        country = c;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "office")
    public Set<Directory> getDirInOffice(){
        return this.dirInOffice;
    }

    public void setDirInOffice(Set<Directory> dio) {
        this.dirInOffice = dio;
    }


}
