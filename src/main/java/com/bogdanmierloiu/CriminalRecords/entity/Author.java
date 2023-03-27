package com.bogdanmierloiu.CriminalRecords.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Length(min = 13, max = 13, message = "The personal code must be exactly 13 characters")
    @Pattern(regexp = "^[0-9]*$", message = "Only numeric characters are allowed")
    @Column(name = "personal_numerical_code", unique = true, nullable = false)
    private String personalCode;

    @ManyToMany(mappedBy = "authors")
    @ToString.Exclude
    private List<CriminalFile> criminalFiles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Author author = (Author) o;
        return getId() != null && Objects.equals(getId(), author.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
