package com.chemstore.model.materials;

import com.chemstore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Data
public class Apparatus extends AbstractEntity {

    @NotBlank(message = "Description is required")
    private String description;

    private String capacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apparatus apparatus = (Apparatus) o;
        return description.equals(apparatus.description) && Objects.equals(capacity, apparatus.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, capacity);
    }
}
