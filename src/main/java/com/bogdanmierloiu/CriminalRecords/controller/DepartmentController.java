package com.bogdanmierloiu.CriminalRecords.controller;

import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentRequest;
import com.bogdanmierloiu.CriminalRecords.dto.department.DepartmentResponse;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationRequest;
import com.bogdanmierloiu.CriminalRecords.dto.police_station.PoliceStationResponse;
import com.bogdanmierloiu.CriminalRecords.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminal-records/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<?> add(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.add(departmentRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAll() {
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.update(departmentRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
