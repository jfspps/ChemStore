package com.chemstore.ChemStore.model.orders;

import com.chemstore.ChemStore.model.AbstractEntity;
import com.chemstore.ChemStore.model.materials.StockChemical;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Data
public class ChemicalOrdered extends AbstractEntity {

    // fetched lazily by default
    @ManyToMany(mappedBy = "chemicalOrderedList")
    private Set<Order> orderList = new HashSet<>();

    @OneToOne
    @NotNull
    private StockChemical stockChemical;

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
        ChemicalOrdered that = (ChemicalOrdered) o;
        return quantityOrdered == that.quantityOrdered && Double.compare(that.price, price) == 0 && stockChemical.equals(that.stockChemical) && currency == that.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockChemical, quantityOrdered, price, currency);
    }
}
