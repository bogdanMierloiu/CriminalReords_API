package com.bogdanmierloiu.CriminalRecords.dto.date;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DateTimeRequest {
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
}
