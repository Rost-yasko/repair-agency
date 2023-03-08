package domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Service implements Serializable {

    private static final long serialVersionUID = 282593431885627033L;
    private int id;
    private String name;
    private String description;
    private String silver;
    private BigDecimal price_silver;
    private String gold;
    private BigDecimal price_gold;

    public Service() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public BigDecimal getPrice_silver() {
        return price_silver;
    }

    public void setPrice_silver(BigDecimal price_silver) {
        this.price_silver = price_silver;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public BigDecimal getPrice_gold() {
        return price_gold;
    }

    public void setPrice_gold(BigDecimal price_gold) {
        this.price_gold = price_gold;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", silver = '" + silver + '\'' +
                ", price_silver = " + price_silver +
                ", gold = '" + gold + '\'' +
                ", price_gold = " + price_gold +
                '}';
    }
}
