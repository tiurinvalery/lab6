package database;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "directories", catalog = "lab6")
public class Directory {
    private Integer directoryId;
    private Office office;
    private String directoryName;
    private Company company;
    private Set<Worker> workerSet = new HashSet<>(0);

    public Directory() {

    }

    public Directory(String dName, Set<Worker> ws) {
        this.directoryName = dName;
        this.workerSet = ws;
    }

    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "directoryid",nullable = false)
    public Integer getDirectoryId(){
        return this.directoryId;
    }
    public void setDirectoryId(Integer dId) {
        this.directoryId = dId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="companyid")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company c) {
        this.company = c;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name="officeid")
    public Office getOffice() {
        return office;
    }
    public void setOffice(Office o) {
        this.office = o;
    }

    @Column(name="directoryname" , nullable = false)
    public String getDirectoryName() {
        return this.directoryName;
    }
    public void setDirectoryName(String dName) {
        this.directoryName = dName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "directory")
    public Set<Worker> getWorkerSet() {
        return this.workerSet;
    }
    public void setWorkerSet(Set<Worker> ws) {
        this.workerSet =ws;
    }



}



