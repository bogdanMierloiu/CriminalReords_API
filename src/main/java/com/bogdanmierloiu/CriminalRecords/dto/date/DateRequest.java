package com.bogdanmierloiu.CriminalRecords.dto.date;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DateRequest {

    private LocalDate dateFrom;
    private LocalDate dateTo;
}
