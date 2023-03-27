package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CrimeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @OneToOne(mappedBy = "crimeType", cascade = CascadeType.ALL, orphanRemoval = true)
    private CriminalFile criminalFile;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CrimeType crimeType = (CrimeType) o;
        return getId() != null && Objects.equals(getId(), crimeType.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
