package ticketreservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String ticketid;
    private String status;

    @PostPersist
    public void onPostPersist(){
        Paycompleted paycompleted = new Paycompleted();
        BeanUtils.copyProperties(this, paycompleted);
        paycompleted.publishAfterCommit();


        Payfailed payfailed = new Payfailed();
        BeanUtils.copyProperties(this, payfailed);
        payfailed.publishAfterCommit();


        PayCanceled payCanceled = new PayCanceled();
        BeanUtils.copyProperties(this, payCanceled);
        payCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
