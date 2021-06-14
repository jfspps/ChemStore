package com.chemstore.ChemStore.model.orders;

import com.chemstore.ChemStore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// table name ORDER conflicts with H2 reserved word
@Entity
@Data
@Table(name = "ChemStoreOrders")
public class Order extends AbstractEntity {

    @NotBlank(message = "Enter a unique order number or identifier")
    private String orderNumber;

    @FutureOrPresent(message = "Order cannot be placed in the past")
    @NotNull
    private LocalDateTime orderDateAndTime;

    @ManyToMany
    @JoinTable(
            name = "ORD_APP",
            joinColumns = @JoinColumn(name = "ORD_ID"),
            inverseJoinColumns = @JoinColumn(name = "APP_ID"))
    private Set<ApparatusOrdered> apparatusOrderedList = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "ORD_CHEM",
            joinColumns = @JoinColumn(name = "ORD_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHEM_ID"))
    private Set<ChemicalOrdered> chemicalOrderedList = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber.equals(order.orderNumber) && orderDateAndTime.equals(order.orderDateAndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderDateAndTime);
    }
}
