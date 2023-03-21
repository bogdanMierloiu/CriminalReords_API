package com.bogdanmierloiu.CriminalRecords.mapper;

import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationRequest;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import com.bogdanmierloiu.CriminalRecords.entity.PoliceStation;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
public interface PoliceStationMapper {

    PoliceStation map(PoliceStationRequest policeStationRequest);

    PoliceStationResponse map(PoliceStation policeStation);

    List<PoliceStationResponse> map(List<PoliceStation> list);

}
