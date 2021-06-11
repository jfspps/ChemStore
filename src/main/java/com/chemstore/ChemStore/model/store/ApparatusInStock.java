package com.chemstore.ChemStore.model.store;

import com.chemstore.ChemStore.model.AbstractEntity;
import com.chemstore.ChemStore.model.materials.StockApparatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Data
public class ApparatusInStock extends AbstractEntity {

    @OneToOne
    private StockApparatus apparatus;

    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApparatusInStock that = (ApparatusInStock) o;
        return quantity == that.quantity && apparatus.equals(that.apparatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apparatus, quantity);
    }
}
