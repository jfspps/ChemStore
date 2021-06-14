package com.chemstore.model.store;

import com.chemstore.model.AbstractEntity;
import com.chemstore.model.materials.StockChemical;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Data
public class ChemicalInStock extends AbstractEntity {

    @OneToOne
    private StockChemical chemical;

    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChemicalInStock that = (ChemicalInStock) o;
        return quantity == that.quantity && chemical.equals(that.chemical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chemical, quantity);
    }
}
