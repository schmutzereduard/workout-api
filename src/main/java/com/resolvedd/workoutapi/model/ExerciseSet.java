package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(
        name = "exercise_set",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_exercise_set_number",
                        columnNames = {"workout_exercise_id", "set_number"}
                )
        }
)
public class ExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "set_number", nullable = false)
    private int setNumber;

    @Column(name = "weight", precision = 5, scale = 2, nullable = false)
    private BigDecimal weight;

    @Column(name = "target_repetitions_min", nullable = false)
    private int targetRepetitionsMin;

    @Column(name = "target_repetitions_max", nullable = false)
    private int targetRepetitionsMax;

    @Column(name = "actual_repetitions", nullable = false)
    private int actualRepetitions;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_exercise_id")
    private WorkoutExercise exercise;
}
