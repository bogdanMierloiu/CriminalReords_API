package com.bogdanmierloiu.CriminalRecords.dto.policeman;

import lombok.Data;

@Data
public class PolicemanRequest {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Long policeStationId;
    private Long departmentId;

}
