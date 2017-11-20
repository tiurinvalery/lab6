package database;
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
    public Worker(Integer id,Company c,Directory d,Integer age,String wName, String wPosition) {
        this.company = c;
        this.directory =d;
        this.workerAge=age;
        this.workerName = wName;
        this.workerPosition=wPosition;
        this.workerId = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (workerId != null ? !workerId.equals(worker.workerId) : worker.workerId != null) return false;
        if (company != null ? !company.equals(worker.company) : worker.company != null) return false;
        if (directory != null ? !directory.equals(worker.directory) : worker.directory != null) return false;
        if (workerAge != null ? !workerAge.equals(worker.workerAge) : worker.workerAge != null) return false;
        if (workerName != null ? !workerName.equals(worker.workerName) : worker.workerName != null) return false;
        return workerPosition != null ? workerPosition.equals(worker.workerPosition) : worker.workerPosition == null;
    }

}
