package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(
        name = "mesocycle_template",
        uniqueConstraints =  {
                @UniqueConstraint(
                        name = "mesocycle_template_week_day_number_uk",
                        columnNames = {"mesocycle_id", "workout_template_id", "week_number", "day_number"}
                )
        })
public class MesocycleTemplate extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mesocycle_id", nullable = false)
    private Mesocycle mesocycle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_template_id", nullable = false)
    private WorkoutTemplate workoutTemplate;

    @Column(name = "week_number", nullable = false)
    private int weekNumber;

    @Column(name = "day_number", nullable = false)
    private int dayNumber;
}