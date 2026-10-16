package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "exercise")
public class Exercise extends SyncableEntity {

    @Column(name ="name", unique = true, nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;
}
