package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "working_set")
public class WorkingSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "weight", precision = 5, scale = 2, nullable = false)
    private BigDecimal weight;

    @Column(name = "goal")
    private int goal;

    @Column(name = "actual")
    private int actual;

    @ManyToOne
    @JoinColumn(name = "session_exercise_id")
    private SessionExercise sessionExercise;
}
