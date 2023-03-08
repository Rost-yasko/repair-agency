package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {

    private static final long serialVersionUID = -7775940569281308692L;
    private int id;
    private Timestamp dataOfPosition;
    private Timestamp completionDate;
    private String status;
    private int userId;


    public Order() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }

    public Timestamp getDataOfPosition() {
        return dataOfPosition;
    }

    public void setDataOfPosition(Timestamp dataOfPosition) {
        this.dataOfPosition = dataOfPosition;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order { " +
                " id = " + id +
                ", dataOfPosition = " + dataOfPosition +
                ", completionDate = " + completionDate +
                ", status = '" + status + '\'' +
                ", userId = " + userId +
                '}';
    }
}
