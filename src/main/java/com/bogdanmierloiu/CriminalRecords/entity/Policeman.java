package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "policeman")
public class Policeman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private PoliceStation policeStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "policeman")
    private List<CriminalFile> criminalFiles = new ArrayList<>();


}
