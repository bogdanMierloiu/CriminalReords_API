package com.bogdanmierloiu.CriminalRecords.controller;

import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationRequest;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import com.bogdanmierloiu.CriminalRecords.service.PoliceStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminal-records/police-station")
@RequiredArgsConstructor
public class PoliceStationController {

    private final PoliceStationService policeStationService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody PoliceStationRequest policeStation) {
        policeStationService.add(policeStation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/add-26-station")
    public ResponseEntity<?> add26Station() {
        policeStationService.add26();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping

    public ResponseEntity<List<PoliceStationResponse>> getAll() {
        return new ResponseEntity<>(policeStationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliceStationResponse> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(policeStationService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PoliceStationRequest policeStation) {
        policeStationService.update(policeStation);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        policeStationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
