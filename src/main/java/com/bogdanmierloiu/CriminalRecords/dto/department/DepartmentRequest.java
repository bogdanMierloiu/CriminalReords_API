package com.bogdanmierloiu.CriminalRecords.dto.department;

import lombok.Data;


@Data

public class DepartmentRequest {
    private Long id;
    private String name;
    private Long policeStationId;


}
