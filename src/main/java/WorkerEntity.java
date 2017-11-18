import org.hibernate.annotations.OptimisticLockType;

import java.io.Serializable;
import javax.persistence.*;


@Entity
    @org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
    @Table(name = "workers", uniqueConstraints = {
           @UniqueConstraint(columnNames = "workerid")
    })
    public class WorkerEntity {
    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workerid" , unique = true, nullable = false)
    private Integer workerId;

    //Foreignkey TODO: Google how to Add foreign key
    @Column(name = "directoryid")
    private Integer directoryId;

    @Column(name = "companyid")
    //@Foreignkey
    private Integer companyId;

    @Column(name = "workername" , length = 100)
    private String workerName;

    @Column(name = "workerage")
    private Integer workerAge;

    @Column(name="workerposition")
    private String workerPosition;



    }
