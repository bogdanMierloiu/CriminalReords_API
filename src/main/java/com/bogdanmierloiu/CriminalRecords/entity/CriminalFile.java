package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "criminal_file", uniqueConstraints = {@UniqueConstraint(columnNames = {"number", "police_station_id"})})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CriminalFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", unique = true, nullable = false)
    private Long number;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "legal_qualification", nullable = false)
    private String legalQualification;

    @Column(name = "date_time_crime", nullable = false)
    private LocalDateTime dateTimeCrime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "police_station_id", nullable = false)
    @ToString.Exclude
    private PoliceStation policeStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policeman_id", nullable = false)
    @ToString.Exclude
    private Policeman policeman;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    @ToString.Exclude
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crime_type_id")
    @ToString.Exclude
    private CrimeType crimeType;

    @ManyToMany
    @JoinTable(name = "criminal_file_author",
            joinColumns = @JoinColumn(name = "criminal_file_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @ToString.Exclude
    private List<Author> authors = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CriminalFile that = (CriminalFile) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
