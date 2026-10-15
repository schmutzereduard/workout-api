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
        name = "workout_exercise",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "workout_exercise_order_uk",
                        columnNames = {"workout_id", "order_in_workout"}
                )
        }
)
public class WorkoutExercise extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "order_in_workout", nullable = false)
    private Integer orderInWorkout;

    @Column(name = "target_sets", nullable = false)
    private Integer targetSets;

    @Column(name = "target_repetitions_min", nullable = false)
    private Integer targetRepetitionsMin;

    @Column(name = "target_repetitions_max", nullable = false)
    private Integer targetRepetitionsMax;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseSet> exerciseSets = new ArrayList<>();
}