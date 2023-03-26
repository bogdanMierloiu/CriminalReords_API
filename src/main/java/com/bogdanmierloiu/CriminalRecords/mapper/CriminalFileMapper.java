package com.bogdanmierloiu.CriminalRecords.mapper;

import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileRequest;
import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileResponse;
import com.bogdanmierloiu.CriminalRecords.entity.CriminalFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CriminalFileMapper {
    CriminalFile map(CriminalFileRequest request);
    CriminalFileResponse map(CriminalFile criminalFile);
    List<CriminalFileResponse> map(List<CriminalFile> criminalFileList);
}
