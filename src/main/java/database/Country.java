package database;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "countries" , catalog = "lab6")
public class Country {
    private Integer countryId;
    private String countryName;
    private Set<Office> officesInCountry = new HashSet<Office>(0);


    public Country() {

    }
    public Country(Integer id){
        this.countryId = id;
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





}
