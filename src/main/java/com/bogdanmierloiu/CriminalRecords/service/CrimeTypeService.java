package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.dto.crime_type.CrimeTypeRequest;
import com.bogdanmierloiu.CriminalRecords.dto.crime_type.CrimeTypeResponse;
import com.bogdanmierloiu.CriminalRecords.entity.CrimeType;
import com.bogdanmierloiu.CriminalRecords.exception.NotFoundException;
import com.bogdanmierloiu.CriminalRecords.mapper.CrimeTypeMapper;
import com.bogdanmierloiu.CriminalRecords.repository.CrimeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CrimeTypeService implements Crud<CrimeTypeRequest, CrimeTypeResponse> {

    private final CrimeTypeRepository crimeTypeRepository;
    private final CrimeTypeMapper mapper;

    @Override
    public void add(CrimeTypeRequest request) {
        crimeTypeRepository.save(mapper.map(request));
    }

    @Override
    public List<CrimeTypeResponse> getAll() {
        return mapper.map(crimeTypeRepository.findAll());
    }

    @Override
    public CrimeTypeResponse findById(Long id) {
        return mapper.map(crimeTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The crime type with " + id + " not found!")
        ));
    }

    @Override
    public void update(CrimeTypeRequest request) {
        CrimeType crimeTypeToUpdate = crimeTypeRepository.findById(request.getId()).orElseThrow(
                () -> new NotFoundException("The crime type with " + request.getId() + " not found!")
        );
        crimeTypeToUpdate.setType(request.getType());
        crimeTypeRepository.save(crimeTypeToUpdate);

    }

    @Override
    public void delete(Long id) {
        CrimeType crimeTypeToDelete = crimeTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The crime type with " + id + " not found!")
        );
        crimeTypeRepository.delete(crimeTypeToDelete);
    }
}
