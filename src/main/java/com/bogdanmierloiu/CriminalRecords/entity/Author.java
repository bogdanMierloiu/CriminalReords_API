package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "personal_numerical_code", unique = true, nullable = false)
    private String personalCode;

    @ManyToMany(mappedBy = "authors")
    private List<CriminalFile> criminalFiles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "author_crime_type",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "crime_type_id"))
    private List<CrimeType> crimeTypes = new ArrayList<>();
}
