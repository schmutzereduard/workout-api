package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "mesocycle")
public class Mesocycle extends SyncableEntity {

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "target_weeks", nullable = false)
    private Integer targetWeeks;

    @Column(name = "deload_week", nullable = false)
    private Integer deloadWeek;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "mesocycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MesocycleTemplate> mesocycleTemplates = new ArrayList<>();
}