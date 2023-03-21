package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "criminal_file")
public class CriminalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", unique = true, nullable = false)
    private Long number;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "legal_qualification", nullable = false)
    private LocalDate legalQualification;

    @Column(name = "date_time_crime", nullable = false)
    private LocalDateTime dateTimeCrime;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policeman_id", nullable = false)
    private Policeman policeman;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "crime_type_id", unique = true)
    private CrimeType crimeType;

    @ManyToMany
    @JoinTable(name = "criminal_file_author",
            joinColumns = @JoinColumn(name = "criminal_file_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();


}
