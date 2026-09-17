package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkoutExercise> exercises = new ArrayList<>();

    public void addWorkoutExercise(WorkoutExercise workoutExercise) {
        exercises.add(workoutExercise);
        workoutExercise.setWorkout(this);
    }
}
