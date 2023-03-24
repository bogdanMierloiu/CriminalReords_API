package com.bogdanmierloiu.CriminalRecords.mapper;

import com.bogdanmierloiu.CriminalRecords.dto.crime_type.CrimeTypeRequest;
import com.bogdanmierloiu.CriminalRecords.dto.crime_type.CrimeTypeResponse;
import com.bogdanmierloiu.CriminalRecords.entity.CrimeType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CrimeTypeMapper {

    CrimeType map(CrimeTypeRequest request);

    CrimeTypeResponse map(CrimeType crimeType);

    List<CrimeTypeResponse> map(List<CrimeType> crimeTypeList);

}
