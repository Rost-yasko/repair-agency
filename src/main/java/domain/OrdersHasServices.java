package domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrdersHasServices implements Serializable {

    private static final long serialVersionUID = -8276157176067777920L;
    private int id;
    private BigDecimal price;
    private int serverId;
    private int ordersId;


    public OrdersHasServices(){}


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public BigDecimal getPrice() {return price;}

    public void setPrice(BigDecimal price) {this.price = price;}

    public int getServerId() {return serverId;}

    public void setServerId(int serverId) {this.serverId = serverId;}

    public int getOrdersId() {return ordersId;}

    public void setOrdersId(int ordersId) {this.ordersId = ordersId;}
}
