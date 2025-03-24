package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "workout_session")
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_day_id")
    private TrainingDay trainingDay;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Column(name = "notes")
    private String notes;
}