package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileRequest;
import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileResponse;
import com.bogdanmierloiu.CriminalRecords.entity.CriminalFile;
import com.bogdanmierloiu.CriminalRecords.exception.NotFoundException;
import com.bogdanmierloiu.CriminalRecords.mapper.CriminalFileMapper;
import com.bogdanmierloiu.CriminalRecords.repository.CrimeTypeRepository;
import com.bogdanmierloiu.CriminalRecords.repository.CriminalFileRepository;
import com.bogdanmierloiu.CriminalRecords.repository.DepartmentRepository;
import com.bogdanmierloiu.CriminalRecords.repository.PolicemanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CriminalFileService implements Crud<CriminalFileRequest, CriminalFileResponse> {
    private final CriminalFileRepository criminalFileRepository;
    private final CrimeTypeRepository crimeTypeRepository;
    private final DepartmentRepository departmentRepository;
    private final PolicemanRepository policemanRepository;
    private final CriminalFileMapper criminalFileMapper;

    @Override
    public void add(CriminalFileRequest request) {
        CriminalFile criminalfile = criminalFileMapper.map(request);
        criminalfile.setCrimeType(crimeTypeRepository.findById(request.getCrimeTypeId()).orElseThrow(
                () -> new NotFoundException("The crime type with id " + request.getCrimeTypeId() + " not found")
        ));
        criminalfile.setDepartment(departmentRepository.findById(request.getDepartmentId()).orElseThrow(
                () -> new NotFoundException("The department with id " + request.getDepartmentId() + " not found")
        ));
        criminalfile.setPoliceman(policemanRepository.findById(request.getPolicemanId()).orElseThrow(
                () -> new NotFoundException("The policeman with id " + request.getPolicemanId() + " not found")
        ));
        criminalFileRepository.save(criminalfile);
    }

    @Override
    public List<CriminalFileResponse> getAll() {
        return null;
    }

    @Override
    public CriminalFileResponse findById(Long id) {
        return null;
    }

    @Override
    public void update(CriminalFileRequest request) {

    }

    @Override
    public void delete(Long id) {

    }
}
