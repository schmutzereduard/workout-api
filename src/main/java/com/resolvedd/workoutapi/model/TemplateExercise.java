package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "template_exercise")
public class TemplateExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private WorkoutTemplate workoutTemplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "order_in_workout", nullable = false)
    private Integer exerciseOrder;

    @Column(name = "target_sets", nullable = false)
    private Integer targetSets = 3;

    @Column(name = "target_repetitions_min", nullable = false)
    private Integer targetRepetitionsMin = 8;

    @Column(name = "target_repetitions_max", nullable = false)
    private Integer targetRepetitionsMax = 12;
}