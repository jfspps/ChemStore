package com.chemstore.ChemStore.model.materials;

import com.chemstore.ChemStore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Data
public class Apparatus extends AbstractEntity {

    @NotBlank(message = "Description is required")
    private String description;

    private String capacity;

    @Embedded
    @NotNull
    private Supplier supplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apparatus apparatus = (Apparatus) o;
        return description.equals(apparatus.description) && Objects.equals(capacity, apparatus.capacity) && supplier.equals(apparatus.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, capacity, supplier);
    }
}
