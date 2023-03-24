package com.bogdanmierloiu.CriminalRecords.dto.department;

import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import com.bogdanmierloiu.CriminalRecords.entity.PoliceStation;
import lombok.Data;

@Data
public class DepartmentResponse {
    private Long id;
    private String name;
    private PoliceStationResponse policeStation;


}
