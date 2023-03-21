package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.entity.PoliceStation;
import com.bogdanmierloiu.CriminalRecords.repository.PoliceStationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PoliceStationService {

    private final PoliceStationRepository policeStationRepository;

    public PoliceStationService(PoliceStationRepository policeStationRepository) {
        this.policeStationRepository = policeStationRepository;
    }

    public void add(PoliceStation policeStationRequest) {
        PoliceStation policeStation = new PoliceStation();
        policeStation.setName(policeStationRequest.getName());
        policeStationRepository.save(policeStation);
    }

    public void add26() {
        for (var i = 1; i <= 26; i++) {
            PoliceStation policeStation = new PoliceStation();
            policeStation.setName("Sectia " + i + " Politie");
            policeStationRepository.save(policeStation);
        }
    }
}
