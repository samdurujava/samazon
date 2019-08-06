package com.example.samazon.Beans;
import javax.persistence.*;

@Entity
@Table(name="Product_Data")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;

    @Column(name = "taxable")
    private boolean taxable;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "history_id")
    private History history;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }
}
