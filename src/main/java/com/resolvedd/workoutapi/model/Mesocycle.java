package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "mesocycle")
public class Mesocycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "target_weeks", nullable = false)
    private Integer targetWeeks;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status", nullable = false)
    private MesocycleStatus status = MesocycleStatus.INACTIVE;

    @OneToMany(mappedBy = "mesocycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutTemplate> workoutTemplates = new ArrayList<>();
}
