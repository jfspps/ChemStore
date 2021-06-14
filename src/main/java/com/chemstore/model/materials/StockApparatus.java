package com.chemstore.model.materials;

import com.chemstore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Data
public class StockApparatus extends AbstractEntity {

    @OneToOne
    @NotNull
    private Apparatus apparatus;

    @OneToOne
    @NotNull
    private Supplier supplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockApparatus that = (StockApparatus) o;
        return apparatus.equals(that.apparatus) && supplier.equals(that.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apparatus, supplier);
    }
}
