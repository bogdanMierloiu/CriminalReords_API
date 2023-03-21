package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CrimeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToOne(mappedBy = "crimeType", cascade = CascadeType.ALL, orphanRemoval = true)
    private CriminalFile criminalFile;

    @ManyToMany(mappedBy = "crimeTypes")
    private List<Author> authors = new ArrayList<>();
}
