package com.bogdanmierloiu.CriminalRecords.controller;

import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileRequest;
import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileResponse;
import com.bogdanmierloiu.CriminalRecords.service.CriminalFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminal-records/criminal-file")
@RequiredArgsConstructor
public class CriminalFileController implements CrudController<CriminalFileRequest, CriminalFileResponse> {

    private final CriminalFileService criminalFileService;

    @Override
    @PostMapping
    public ResponseEntity<?> add(@RequestBody CriminalFileRequest request) {
        criminalFileService.add(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CriminalFileResponse>> getAll() {
        return new ResponseEntity<>(criminalFileService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<CriminalFileResponse> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(criminalFileService.findById(id), HttpStatus.OK);
    }

    @Override
    @PutMapping
    public ResponseEntity<?> update(@RequestBody CriminalFileRequest request) {
        criminalFileService.update(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
