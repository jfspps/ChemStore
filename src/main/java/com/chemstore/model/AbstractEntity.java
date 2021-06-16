package com.chemstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private String serialNumber;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    @PrePersist
    public void setCreate_Date(){
        this.setCreatedOn(LocalDateTime.now());
    }

    @PreUpdate
    public void doSomethingBeforeUpdating(){
        this.setUpdatedOn(LocalDateTime.now());
    }
}
