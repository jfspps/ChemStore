package com.chemstore.model.materials;

import com.chemstore.model.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Data
public class Supplier extends AbstractEntity {

    @NotBlank(message = "Cannot use a blank company name")
    private String companyName;

    @Email(message = "Enter a valid email address")
    private String companyEmail;

    private String companyPhone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return companyName.equals(supplier.companyName) && Objects.equals(companyEmail, supplier.companyEmail) && Objects.equals(companyPhone, supplier.companyPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyPhone);
    }
}
