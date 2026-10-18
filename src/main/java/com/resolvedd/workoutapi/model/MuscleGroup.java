package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "muscle_group")
@Data
public class MuscleGroup extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private MuscleGroupName name;

    @ManyToMany(mappedBy = "muscleGroups")
    private List<Exercise> exercises = new ArrayList<>();
}