package com.bogdanmierloiu.CriminalRecords.controller;

import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentRequest;
import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentResponse;
import com.bogdanmierloiu.CriminalRecords.dto.policeman.PolicemanRequest;
import com.bogdanmierloiu.CriminalRecords.dto.policeman.PolicemanResponse;
import com.bogdanmierloiu.CriminalRecords.service.DepartmentService;
import com.bogdanmierloiu.CriminalRecords.service.PolicemanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminal-records/policeman")
@RequiredArgsConstructor
public class PolicemanController {
    private final PolicemanService policemanService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody PolicemanRequest policemanRequest) {
        policemanService.add(policemanRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PolicemanResponse>> getAll() {
        return new ResponseEntity<>(policemanService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicemanResponse> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(policemanService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PolicemanRequest policemanRequest) {
        policemanService.update(policemanRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        policemanService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
