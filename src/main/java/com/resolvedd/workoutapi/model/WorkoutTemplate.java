package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "workout_template")
public class WorkoutTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "day_order", nullable = false)
    private Integer dayOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mesocycle_id", nullable = false)
    private Mesocycle mesocycle;

    @OneToMany(mappedBy = "workoutTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TemplateExercise> templateExercises = new ArrayList<>();
}