package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "workout")
public class Workout extends SyncableEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_template_id")
    private WorkoutTemplate workoutTemplate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "notes")
    private String notes;

    @Column(name = "is_deload",  nullable = false)
    private Boolean isDeload;

    @Column(name = "completed_at", nullable = false)
    private LocalDateTime completedAt;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> exercises = new ArrayList<>();
}