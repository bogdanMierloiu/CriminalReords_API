package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationRequest;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import com.bogdanmierloiu.CriminalRecords.entity.PoliceStation;
import com.bogdanmierloiu.CriminalRecords.exception.NotFoundException;
import com.bogdanmierloiu.CriminalRecords.mapper.PoliceStationMapper;
import com.bogdanmierloiu.CriminalRecords.repository.PoliceStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PoliceStationService implements Crud<PoliceStationRequest, PoliceStationResponse> {

    private final PoliceStationRepository policeStationRepository;
    private final PoliceStationMapper mapper;


    public void add(PoliceStationRequest policeStationRequest) {
        PoliceStation policeStation = mapper.map(policeStationRequest);
        policeStationRepository.save(policeStation);
    }

    public void add26() {
        for (var i = 1; i <= 26; i++) {
            PoliceStation policeStation = new PoliceStation();
            policeStation.setName("Sectia " + i + " Politie");
            policeStationRepository.save(policeStation);
        }
    }

    public List<PoliceStationResponse> getAll() {
        return mapper.map(policeStationRepository.findAll());
    }

    public PoliceStationResponse findById(Long id) {
        return mapper.map(policeStationRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Police station with " + id + " not found!")
        ));
    }

    public void update(PoliceStationRequest policeStationRequest) {
        PoliceStation policeStation = policeStationRepository.findById(policeStationRequest.getId()).orElseThrow(
                () -> new NotFoundException("Police station with " + policeStationRequest.getId() + " not found!")
        );
        policeStation.setName(policeStationRequest.getName() != null ? policeStationRequest.getName() : policeStation.getName());
        policeStationRepository.save(policeStation);
    }

    public void delete(Long id) {
        policeStationRepository.delete(policeStationRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The Police Station with id: " + " not found!")
        ));
    }


}
