package com.bogdanmierloiu.CriminalRecords.controller;

import com.bogdanmierloiu.CriminalRecords.entity.PoliceStation;
import com.bogdanmierloiu.CriminalRecords.service.PoliceStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("criminal-records/police-station")
@RequiredArgsConstructor
public class PoliceStationController {

    private final PoliceStationService policeStationService;

    @PostMapping()
    public void add(@RequestBody PoliceStation policeStation) {
        policeStationService.add(policeStation);
    }

    @PostMapping("/add-26-station")
    public void add26Station(){
        policeStationService.add26();
    }
}
