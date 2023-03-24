package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.dto.policeman.PolicemanRequest;
import com.bogdanmierloiu.CriminalRecords.dto.policeman.PolicemanResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Policeman;
import com.bogdanmierloiu.CriminalRecords.exception.NotFoundException;
import com.bogdanmierloiu.CriminalRecords.mapper.DepartmentMapper;
import com.bogdanmierloiu.CriminalRecords.mapper.PolicemanMapper;
import com.bogdanmierloiu.CriminalRecords.repository.DepartmentRepository;
import com.bogdanmierloiu.CriminalRecords.repository.PoliceStationRepository;
import com.bogdanmierloiu.CriminalRecords.repository.PolicemanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PolicemanService implements Crud<PolicemanRequest, PolicemanResponse> {
    private final PolicemanRepository policemanRepository;
    private final PoliceStationRepository policeStationRepository;
    private final DepartmentRepository departmentRepository;
    private final PolicemanMapper policemanMapper;

    @Override
    public void add(PolicemanRequest request) {
        Policeman policeman = policemanMapper.map(request);
        policeman.setPoliceStation(policeStationRepository.findById(request.getPoliceStationId()).orElseThrow(
                () -> new NotFoundException("Police station with id " + request.getPoliceStationId() + " not found")
        ));
        policeman.setDepartment(departmentRepository.findById(request.getDepartmentId()).orElseThrow(
                () -> new NotFoundException("The department with id " + request.getDepartmentId() + " not found!")
        ));
        policemanRepository.save(policeman);
    }

    @Override
    public List<PolicemanResponse> getAll() {
        return policemanMapper.map(policemanRepository.findAll());
    }

    @Override
    public PolicemanResponse findById(Long id) {
        return policemanMapper.map(policemanRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The policeman with id: " + id + " not found")
        ));
    }

    @Override
    public void update(PolicemanRequest request) {
        Policeman policemanToUpdate = policemanRepository.findById(request.getId()).orElseThrow(
                () -> new NotFoundException("The policeman with id: " + request.getId() + " not found")
        );
        policemanToUpdate.setFirstName(request.getFirstName() != null ? request.getFirstName() : policemanToUpdate.getFirstName());
        policemanToUpdate.setMiddleName(request.getMiddleName() != null ? request.getMiddleName() : policemanToUpdate.getMiddleName());
        policemanToUpdate.setLastName(request.getLastName() != null ? request.getLastName() : policemanToUpdate.getLastName());
        policemanToUpdate.setPoliceStation(request.getPoliceStationId() != null ?
                policeStationRepository.findById(request.getPoliceStationId()).orElseThrow(
                        () -> new NotFoundException("The police station with id: " + request.getPoliceStationId() + " not found!")
                ) : policemanToUpdate.getPoliceStation());
        policemanToUpdate.setDepartment(request.getDepartmentId() != null ?
                departmentRepository.findById(request.getDepartmentId()).orElseThrow(
                        () -> new NotFoundException("The department with id: " + request.getDepartmentId() + " not found!")
                ) : policemanToUpdate.getDepartment());
        policemanRepository.save(policemanToUpdate);

    }

    @Override
    public void delete(Long id) {
        Policeman policemanToDelete = policemanRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The policeman with id: " + id + " not found!")
        );
        policemanRepository.delete(policemanToDelete);
    }
}
