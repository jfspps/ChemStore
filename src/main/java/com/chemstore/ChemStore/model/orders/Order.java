package com.chemstore.ChemStore.model.orders;

import com.chemstore.ChemStore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Order extends AbstractEntity {

    @NotBlank(message = "Enter a unique order number or identifier")
    private String orderNumber;

    @PastOrPresent(message = "Order cannot be placed in the future")
    @NotNull
    private LocalDateTime orderDateAndTime;

    @ManyToMany
    @JoinTable(
            name = "Orders_Apparatus",
            joinColumns = @JoinColumn(name = "orderID"),
            inverseJoinColumns = @JoinColumn(name = "apparatusID"))
    private List<ApparatusOrdered> apparatusOrderedList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Orders_Chemical",
            joinColumns = @JoinColumn(name = "orderID"),
            inverseJoinColumns = @JoinColumn(name = "chemicalID"))
    private List<ChemicalOrdered> chemicalOrderedList = new ArrayList<>();

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
