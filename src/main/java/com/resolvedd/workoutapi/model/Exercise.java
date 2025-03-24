package com.resolvedd.workoutapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name = "cues")
    private String cues;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<WorkingSet> workingSets = new ArrayList<>();
}
