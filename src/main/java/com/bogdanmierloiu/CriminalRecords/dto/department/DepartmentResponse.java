package com.bogdanmierloiu.CriminalRecords.dto.department;

import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import lombok.*;


@Data
public class DepartmentResponse {
    private Long id;
    private String name;
    private PoliceStationResponse policeStationResponse;


}
