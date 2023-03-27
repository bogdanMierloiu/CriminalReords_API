package com.bogdanmierloiu.CriminalRecords.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.*;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PoliceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "name",
            unique = true,
            nullable = false
    )
    private String name;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "policeStation")
    @ToString.Exclude
    private List<Policeman> policemen = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "policeStation")
    @ToString.Exclude
    private Set<CriminalFile> criminalFiles = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "policeStation")
    @ToString.Exclude
    private List<Department> departments = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PoliceStation that = (PoliceStation) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
