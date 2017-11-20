package database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "countries" , catalog = "lab6")
public class Country {
    private Integer countryId;
    private String countryName;
    private Set<Office> officesInCountry = new HashSet<Office>(0);
    public static List<Country> countryList = new ArrayList<>();

    public static void addToCountryList(Country c) {countryList.add(c);}

    public Country() {

    }
    public Country(Integer id,String cName){
        this.countryId = id;
        this.countryName = cName;
    }
    public Country(String cName) {
        this.countryName = cName;
    }
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name = "countryid",nullable = false)
    public Integer getCountryId() {
        return this.countryId;
    }
    public void setCountryId(Integer cId){
        this.countryId = cId;
    }
    @Column(name = "countryname", nullable = false)
    public String getCountryName() {
        return this.countryName;
    }
    public void setCountryName(String cName) {
        this.countryName = cName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    public Set<Office> getOfficesInCountry() {
        return this.officesInCountry;
    }
    public void setOfficesInCountry(Set<Office> of){
        this.officesInCountry = of;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != null ? !countryId.equals(country.countryId) : country.countryId != null) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;
        return officesInCountry != null ? officesInCountry.equals(country.officesInCountry) : country.officesInCountry == null;
    }


}
