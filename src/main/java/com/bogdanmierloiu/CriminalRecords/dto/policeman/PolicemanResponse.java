package com.bogdanmierloiu.CriminalRecords.dto.policeman;

import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentResponse;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import lombok.Data;

@Data
public class PolicemanResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private PoliceStationResponse policeStationResponse;
    private DepartmentResponse departmentResponse;

}
