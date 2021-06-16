package com.chemstore.model.materials;

import com.chemstore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Data
public class Reagent extends AbstractEntity {

    @NotBlank(message = "Cannot use a blank CAS ID")
    private String CAS_id;

    @NotBlank(message = "Cannot use a blank chemical name")
    private String chemicalName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reagent reagent = (Reagent) o;
        return CAS_id.equals(reagent.CAS_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CAS_id);
    }
}
