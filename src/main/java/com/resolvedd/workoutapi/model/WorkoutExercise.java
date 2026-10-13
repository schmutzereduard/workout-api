package com.resolvedd.workoutapi.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "workout_exercise",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "workout_exercise_order",
                        columnNames = {"workout_id", "order_in_workout"}
                )
        }
)
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "order_in_workout", nullable = false)
    private Integer orderInWorkout;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseSet> exerciseSets = new ArrayList<>();

}