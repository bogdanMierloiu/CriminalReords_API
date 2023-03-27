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
@Table(name = "policeman",uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name", "police_station_id"})})
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
            name = "middle_name"
    )
    private String middleName;

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

    @ManyToOne
    @ToString.Exclude
    private PoliceStation policeStation;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    @ToString.Exclude
    private Department department;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "policeman")
    @ToString.Exclude
    private List<CriminalFile> criminalFiles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Policeman policeman = (Policeman) o;
        return getId() != null && Objects.equals(getId(), policeman.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
