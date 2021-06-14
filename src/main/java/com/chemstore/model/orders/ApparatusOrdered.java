package com.chemstore.model.orders;

import com.chemstore.model.AbstractEntity;
import com.chemstore.model.materials.StockApparatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Data
public class ApparatusOrdered extends AbstractEntity {

    // fetched lazily by default
    @ManyToMany(mappedBy = "apparatusOrderedList")
    private Set<Order> orderList = new HashSet<>();

    @OneToOne
    @NotNull
    private StockApparatus stockApparatus;

    @NotBlank(message = "Enter a value > 0")
    @Size(min = 1, message = "Minimum quantity to order is 1")
    private int quantityOrdered;

    @NotBlank(message = "Enter a price > 0")
    @Size(message = "Price must be > 0")
    private double price;

    @Enumerated(value = EnumType.STRING)
    @NotNull(message = "Choose a currency")
    private Currency currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApparatusOrdered that = (ApparatusOrdered) o;
        return quantityOrdered == that.quantityOrdered && Double.compare(that.price, price) == 0 && stockApparatus.equals(that.stockApparatus) && currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockApparatus, quantityOrdered, price, currency);
    }
}
