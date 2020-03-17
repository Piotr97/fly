package com.model.entity;

import com.model.BuyStatus;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Tourist tourist;
    @Enumerated(EnumType.STRING)
    private BuyStatus buyStatus;
    private int seatPlace;
    private String transactionUUID;


    public int getSeatPlace() {
        return seatPlace;
    }
    public String getTransactionUUID() {
        return transactionUUID;
    }

    public void setTransactionUUID(String transactionUUID) {
        this.transactionUUID = transactionUUID;
    }

    public void setSeatPlace(int seatPlace) {
        this.seatPlace = seatPlace;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public BuyStatus getBuyStatus() {
        return buyStatus;
    }

    public void setBuyStatus(BuyStatus buyStatus) {
        this.buyStatus = buyStatus;
    }



    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", tourist=" + tourist +
                ", buyStatus=" + buyStatus +
                ", seatPlace=" + seatPlace +
                ", transactionUUID=" + transactionUUID +
                '}';
    }
}
