package com.chemstore.ChemStore.model.materials;

import com.chemstore.ChemStore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
public class StockChemical extends AbstractEntity {

    @OneToOne
    @NotNull
    private Reagent reagent;

    @Enumerated(value = EnumType.STRING)
    private UnitOfMeasure measure;

    @OneToOne
    @NotNull
    private Supplier supplier;

    private String mass;

    private String volume;

    private String concentration;

    private String density;

    private LocalDate expiryDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockChemical that = (StockChemical) o;
        return reagent.equals(that.reagent) &&
                measure == that.measure &&
                supplier.equals(that.supplier) &&
                Objects.equals(mass, that.mass) &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(concentration, that.concentration) &&
                Objects.equals(density, that.density) &&
                Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reagent, measure, supplier, mass, volume, concentration, density, expiryDate);
    }
}
