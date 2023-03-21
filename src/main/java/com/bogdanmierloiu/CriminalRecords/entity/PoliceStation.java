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
@ToString
@RequiredArgsConstructor
public class PoliceStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "policeStation")
    @ToString.Exclude
    private List<Policeman> policemen = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "policeStation")
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
