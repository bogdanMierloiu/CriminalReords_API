package com.bogdanmierloiu.CriminalRecords.dto.criminal_file;

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

public class CriminalFileRequest {

    private Long id;

    private Long number;

    private LocalDate registrationDate;

    private String legalQualification;

    private LocalDateTime dateTimeCrime;

    private Long departmentId;

    private Long policemanId;

    private Long crimeTypeId;

    private List<Long> authorsId = new ArrayList<>();


}
