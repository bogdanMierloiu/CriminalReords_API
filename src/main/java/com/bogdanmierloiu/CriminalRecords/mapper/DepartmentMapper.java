package com.bogdanmierloiu.CriminalRecords.mapper;

import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentRequest;
import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentResponse;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationRequest;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Department;
import com.bogdanmierloiu.CriminalRecords.entity.PoliceStation;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper
public interface DepartmentMapper {

    Department map(DepartmentRequest departmentRequest);

    DepartmentResponse map(Department department);

    List<DepartmentResponse> map(List<Department> list);


}
