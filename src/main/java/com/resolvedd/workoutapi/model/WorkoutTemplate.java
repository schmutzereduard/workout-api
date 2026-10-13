package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "workout_template",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "mesocycle_day_order_in_week",
                        columnNames = {"mesocycle_id", "day_order", "week_number"}
                )
        })
public class WorkoutTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "day_order", nullable = false)
    private Integer dayOrder;

    @Column(name = "week_number", nullable = false)
    private Integer weekNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mesocycle_id", nullable = false)
    private Mesocycle mesocycle;

    @OneToMany(mappedBy = "workoutTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TemplateExercise> templateExercises = new ArrayList<>();
}