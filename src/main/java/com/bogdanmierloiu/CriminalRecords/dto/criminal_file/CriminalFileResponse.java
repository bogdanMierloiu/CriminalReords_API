package com.bogdanmierloiu.CriminalRecords.dto.criminal_file;

import com.bogdanmierloiu.CriminalRecords.dto.author.AuthorResponse;
import com.bogdanmierloiu.CriminalRecords.dto.crime_type.CrimeTypeResponse;
import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentResponse;
import com.bogdanmierloiu.CriminalRecords.dto.policeman.PolicemanResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CriminalFileResponse {

    private Long id;

    private Long number;

    private LocalDate registrationDate;

    private String legalQualification;

    private LocalDateTime dateTimeCrime;

    private DepartmentResponse department;

    private PolicemanResponse policeman;

    private CrimeTypeResponse crimeType;

    private List<AuthorResponse> authors = new ArrayList<>();


}
