package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(
        name = "template_exercise",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "template_order_in_workout_uk",
                        columnNames = {"template_id", "order_in_workout"}
                )
        })
public class TemplateExercise extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private WorkoutTemplate workoutTemplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "order_in_workout", nullable = false)
    private Integer exerciseOrder;

    @Column(name ="warmup_sets", nullable = false)
    private Integer warmupSets;

    @Column(name = "target_sets", nullable = false)
    private Integer targetSets;

    @Column(name = "target_repetitions_min", nullable = false)
    private Integer targetRepetitionsMin;

    @Column(name = "target_repetitions_max", nullable = false)
    private Integer targetRepetitionsMax;
}