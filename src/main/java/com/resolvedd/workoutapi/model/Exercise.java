package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "exercise")
public class Exercise extends SyncableEntity {

    @Column(name ="name", unique = true, nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @ManyToMany
    @JoinTable(
            name = "exercise_muscle",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id")
    )
    private List<MuscleGroup> muscleGroups = new ArrayList<>();
}
