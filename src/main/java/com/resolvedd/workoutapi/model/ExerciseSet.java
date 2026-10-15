package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(
        name = "exercise_set",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "exercise_set_number_uk",
                        columnNames = {"workout_exercise_id", "set_number"}
                )
        }
)
public class ExerciseSet extends BaseEntity {

    @Column(name = "set_number", nullable = false)
    private int setNumber;

    @Column(name = "weight", precision = 5, scale = 2, nullable = false)
    private BigDecimal weight;

    @Column(name = "actual_repetitions", nullable = false)
    private int actualRepetitions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_exercise_id")
    private WorkoutExercise workoutExercise;
}
