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
    public Office(Integer oId, Country c, Set<Directory> dirIno) {
        this.officeId = oId;
        this.country = c;
        this.dirInOffice = dirIno;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office office = (Office) o;

        if (officeId != null ? !officeId.equals(office.officeId) : office.officeId != null) return false;
        if (country != null ? !country.equals(office.country) : office.country != null) return false;
        return dirInOffice != null ? dirInOffice.equals(office.dirInOffice) : office.dirInOffice == null;
    }

}
