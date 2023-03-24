package com.bogdanmierloiu.CriminalRecords.controller;

import com.bogdanmierloiu.CriminalRecords.dto.crime_type.CrimeTypeRequest;
import com.bogdanmierloiu.CriminalRecords.dto.crime_type.CrimeTypeResponse;
import com.bogdanmierloiu.CriminalRecords.service.CrimeTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminal-records/crime-type")
@RequiredArgsConstructor
public class CrimeTypeController {

    private final CrimeTypeService crimeTypeService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody CrimeTypeRequest crimeTypeRequest) {
        crimeTypeService.add(crimeTypeRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CrimeTypeResponse>> getAll() {
        return new ResponseEntity<>(crimeTypeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrimeTypeResponse> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(crimeTypeService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CrimeTypeRequest crimeTypeRequest) {
        crimeTypeService.update(crimeTypeRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        crimeTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
