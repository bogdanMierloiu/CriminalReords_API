package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentRequest;
import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentResponse;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Department;
import com.bogdanmierloiu.CriminalRecords.exception.NotFoundException;
import com.bogdanmierloiu.CriminalRecords.mapper.DepartmentMapper;
import com.bogdanmierloiu.CriminalRecords.repository.DepartmentRepository;
import com.bogdanmierloiu.CriminalRecords.repository.PoliceStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService implements Crud<DepartmentRequest, DepartmentResponse> {

    private final DepartmentRepository departmentRepository;
    private final PoliceStationRepository policeStationRepository;
    private final DepartmentMapper mapper;


    @Override
    public void add(DepartmentRequest request) {
        Department departmentToSave = mapper.map(request);
        departmentToSave.setPoliceStation(policeStationRepository.findById(request.getPoliceStationId()).orElseThrow(
                () -> new NotFoundException("The Police Station with " + request.getPoliceStationId() + " not found!")
        ));
        departmentRepository.save(departmentToSave);
    }

    @Override
    public List<DepartmentResponse> getAll() {
        List<DepartmentResponse> responseList = mapper.map(departmentRepository.findAll());
        return responseList;
    }

    @Override
    public DepartmentResponse findById(Long id) {
        return mapper.map(departmentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The department with " + id + " not found")
        ));
    }

    @Override
    public void update(DepartmentRequest request) {
        Department departmentToUpdate = departmentRepository.findById(request.getId()).orElseThrow(
                () -> new NotFoundException("The Department with id " + request.getId() + " not found!")
        );
        departmentToUpdate.setName(request.getName() != null ? request.getName() : departmentToUpdate.getName());
        departmentToUpdate.setPoliceStation(request.getPoliceStationId() != null ?
                policeStationRepository.findById(request.getPoliceStationId()).orElseThrow(
                        () -> new NotFoundException("The police station with id: " + request.getPoliceStationId() + " not found!")) :
                departmentToUpdate.getPoliceStation());
        departmentRepository.save(departmentToUpdate);

    }

    @Override
    public void delete(Long id) {
        Department departmentToDelete = departmentRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The department with id: " + " not found")
        );
        departmentRepository.delete(departmentToDelete);
    }

    public List<DepartmentResponse> findByPoliceStation(Long policeStationId) {
        return mapper.map(departmentRepository.findByPoliceStationId(policeStationId));
    }
}
