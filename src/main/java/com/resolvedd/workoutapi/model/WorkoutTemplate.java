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
        name = "workout_template",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "name_user_uk",
                        columnNames = {"user_id", "name"}
                )
        })
public class WorkoutTemplate extends SyncableEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "workoutTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TemplateExercise> templateExercises = new ArrayList<>();

    @OneToMany(mappedBy = "workoutTemplate")
    private List<MesocycleTemplate> mesocycleUsages = new ArrayList<>();
}