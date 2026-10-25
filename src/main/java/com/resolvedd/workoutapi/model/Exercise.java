package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(
        name = "exercise",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "name_uk",
                        columnNames = {"user_id", "name", "variation"}
                )
        }
)
public class Exercise extends SyncableEntity {

    @Column(name = "user_id")
    private Long userId;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name = "variation", nullable = false)
    private String variation = "";

    @Column(name = "notes")
    private String notes;

    @ManyToMany
    @JoinTable(
            name = "exercise_muscle",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_group_id")
    )
    private List<MuscleGroup> muscleGroups = new ArrayList<>();
}
