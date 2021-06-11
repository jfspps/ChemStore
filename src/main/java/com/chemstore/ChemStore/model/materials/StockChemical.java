package com.chemstore.ChemStore.model.materials;

import com.chemstore.ChemStore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Data
public class StockChemical extends AbstractEntity {

    @Embedded
    private Reagent reagent;

    @Enumerated(value = EnumType.STRING)
    private UnitOfMeasure measure;

    @Embedded
    @NotNull
    private Supplier supplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockChemical that = (StockChemical) o;
        return reagent.equals(that.reagent) && measure == that.measure && supplier.equals(that.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reagent, measure, supplier);
    }
}
