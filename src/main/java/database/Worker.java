package database;

import database.Directory;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "workers", catalog = "lab6")
public class Worker {
    private Integer workerId;
    private Company company;
    private Directory directory;
    private Integer workerAge;
    private String workerName;
    private String workerPosition;

    public Worker() {

    }
    public Worker(Company c,Directory d,Integer age,String wName, String wPosition) {
        this.company = c;
        this.directory =d;
        this.workerAge=age;
        this.workerName = wName;
        this.workerPosition=wPosition;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @PrimaryKeyJoinColumn
    @Column(name = "workerid")
    public Integer getWorkerId() {
        return this.workerId;
    }
    public void setWorkerId(Integer wId) {
        this.workerId = wId;
    }

    @ManyToOne
    @JoinColumn(name = "directoryid")
    public Directory getDirectory() {
        return this.directory;
    }
    public void setDirectory(Directory dir) {
        this.directory = dir;
    }

    @ManyToOne
    @JoinColumn(name = "companyid")
    public Company getCompany(){
        return this.company;
    }
    public void setCompany(Company c) {
        this.company = c;
    }

    @Column(name = "workerage")
    public Integer getWorkerAge() {
        return this.workerAge;
    }
    public void setWorkerAge(Integer wAge) {
        this.workerAge = wAge;
    }

    @Column(name = "workername")
    public String getWorkerName() {
        return this.workerName;
    }
    public void setWorkerName(String wName) {
        this.workerName = wName;
    }

    @Column(name="workerposition")
    public String getWorkerPosition(){
        return this.workerPosition;
    }
    public void setWorkerPosition(String wPosition) {
        this.workerPosition = wPosition;
    }

}
