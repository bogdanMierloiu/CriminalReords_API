package com.bogdanmierloiu.CriminalRecords.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "police_station_id"})})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    @ToString.Exclude
    private List<Policeman> policemen = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    @ToString.Exclude
    private List<CriminalFile> criminalFiles;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private PoliceStation policeStation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Department that = (Department) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
