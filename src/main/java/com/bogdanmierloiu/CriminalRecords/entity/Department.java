package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "police_station_id", nullable = false)
    private PoliceStation policeStation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Policeman> policemen = new ArrayList<>();

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private CriminalFile criminalFile;
}
