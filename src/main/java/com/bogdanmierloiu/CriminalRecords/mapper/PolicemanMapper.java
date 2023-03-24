package com.bogdanmierloiu.CriminalRecords.mapper;

import com.bogdanmierloiu.CriminalRecords.dto.policeman.PolicemanRequest;
import com.bogdanmierloiu.CriminalRecords.dto.policeman.PolicemanResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Policeman;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PolicemanMapper {

    Policeman map(PolicemanRequest policemanRequest);

    PolicemanResponse map(Policeman policeman);

    List<PolicemanResponse> map(List<Policeman> policemanList);
}

