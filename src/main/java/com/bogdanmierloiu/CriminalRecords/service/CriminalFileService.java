package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileRequest;
import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Author;
import com.bogdanmierloiu.CriminalRecords.entity.CriminalFile;
import com.bogdanmierloiu.CriminalRecords.exception.NotFoundException;
import com.bogdanmierloiu.CriminalRecords.mapper.CriminalFileMapper;
import com.bogdanmierloiu.CriminalRecords.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CriminalFileService implements Crud<CriminalFileRequest, CriminalFileResponse> {
    private final CriminalFileRepository criminalFileRepository;
    private final PoliceStationRepository policeStationRepository;
    private final DepartmentRepository departmentRepository;
    private final CrimeTypeRepository crimeTypeRepository;
    private final PolicemanRepository policemanRepository;
    private final AuthorRepository authorRepository;
    private final CriminalFileMapper criminalFileMapper;

    @Override
    public void add(CriminalFileRequest request) {
        CriminalFile criminalfile = criminalFileMapper.map(request);
        criminalfile.setPoliceStation(policeStationRepository.findById(request.getPoliceStationId()).orElseThrow(
                () -> new NotFoundException("The police station with id " + request.getPoliceStationId() + " not found")
        ));
        criminalfile.setDepartment(departmentRepository.findById(request.getDepartmentId()).orElseThrow(
                () -> new NotFoundException("The department with id " + request.getDepartmentId() + " not found")
        ));
        criminalfile.setCrimeType(crimeTypeRepository.findById(request.getCrimeTypeId()).orElseThrow(
                () -> new NotFoundException("The crime type with id " + request.getCrimeTypeId() + " not found")
        ));
        criminalfile.setPoliceman(policemanRepository.findById(request.getPolicemanId()).orElseThrow(
                () -> new NotFoundException("The policeman with id " + request.getPolicemanId() + " not found")
        ));
        criminalFileRepository.save(criminalfile);
    }

    @Override
    public List<CriminalFileResponse> getAll() {
        return criminalFileMapper.map(criminalFileRepository.findAll());
    }

    @Override
    public CriminalFileResponse findById(Long id) {
        return criminalFileMapper.map(criminalFileRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The criminal file with id " + id + " not found!")
        ));
    }

    @Override
    public void update(CriminalFileRequest request) {
        CriminalFile criminalFileToUpdate = criminalFileRepository.findById(request.getId()).orElseThrow(
                () -> new NotFoundException("The criminal file with id " + request.getId() + " not found")
        );
        criminalFileToUpdate.setNumber(request.getNumber() != null ? request.getNumber() : criminalFileToUpdate.getNumber());
        criminalFileToUpdate.setRegistrationDate(request.getRegistrationDate() != null ? request.getRegistrationDate() : criminalFileToUpdate.getRegistrationDate());
        criminalFileToUpdate.setDateTimeCrime(request.getDateTimeCrime() != null ? request.getDateTimeCrime() : criminalFileToUpdate.getDateTimeCrime());
        criminalFileToUpdate.setLegalQualification(request.getLegalQualification() != null ? request.getLegalQualification() : criminalFileToUpdate.getLegalQualification());
        criminalFileToUpdate.setPoliceStation(request.getPoliceStationId() != null ?
                policeStationRepository.findById(request.getPoliceStationId()).orElseThrow(
                        () -> new NotFoundException("The police station with id " + request.getPoliceStationId() + " not found")
                ) : criminalFileToUpdate.getPoliceStation());
        criminalFileToUpdate.setDepartment(request.getDepartmentId() != null ?
                departmentRepository.findById(request.getDepartmentId()).orElseThrow(
                        () -> new NotFoundException("The department with id " + request.getDepartmentId() + " not found")
                ) : criminalFileToUpdate.getDepartment());
        criminalFileToUpdate.setCrimeType(request.getCrimeTypeId() != null ?
                crimeTypeRepository.findById(request.getCrimeTypeId()).orElseThrow(
                        () -> new NotFoundException("The crime type with id " + request.getCrimeTypeId() + " not found")
                ) : criminalFileToUpdate.getCrimeType());
        criminalFileToUpdate.setPoliceman(request.getPolicemanId() != null ?
                policemanRepository.findById(request.getPolicemanId()).orElseThrow(
                        () -> new NotFoundException("The policeman with id " + request.getPolicemanId() + " not found")
                ) : criminalFileToUpdate.getPoliceman());
        if (request.getAuthorsId() != null) {
            List<Author> authorlist = new ArrayList<>();
            for (var i : request.getAuthorsId()) {
                Author author = authorRepository.findById(i).orElseThrow(
                        () -> new NotFoundException("The autor with id " + i + " not found!")
                );
                authorlist.add(author);
            }
            criminalFileToUpdate.setAuthors(authorlist);
        }
        criminalFileRepository.save(criminalFileToUpdate);
    }

    @Override
    public void delete(Long id) {
        CriminalFile criminalFileToDelete = criminalFileRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The criminal file with id " + id + " not found!")
        );
        criminalFileRepository.delete(criminalFileToDelete);
    }
}
