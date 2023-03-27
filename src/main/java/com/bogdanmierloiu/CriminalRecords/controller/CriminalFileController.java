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

    @GetMapping("/byPoliceStation/{id}")
    public ResponseEntity<List<CriminalFileResponse>> getByPoliceStationId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(criminalFileService.findByPoliceStationId(id), HttpStatus.OK);
    }

    @GetMapping("/unknown-author/{id}")
    public ResponseEntity<List<CriminalFileResponse>> unknownAuthorByPoliceStation(@PathVariable("id") Long id) {
        return new ResponseEntity<>(criminalFileService.filesWithUnknownAuthorByPoliceStation(id), HttpStatus.OK);
    }

    @GetMapping("/byNumber/{number}")
    public ResponseEntity<CriminalFileResponse> getByNumber(@PathVariable("number") Long number) {
        return new ResponseEntity<>(criminalFileService.findByNumber(number), HttpStatus.OK);
    }

    @GetMapping("/byLegalQualification/{legalQualification}")
    public ResponseEntity<List<CriminalFileResponse>> getByLegalQualification(@PathVariable("legalQualification") String legalQualification) {
        return new ResponseEntity<>(criminalFileService.findByLegalQualification(legalQualification), HttpStatus.OK);
    }

    @GetMapping("/byPoliceStation-and-legal-qualification/{policeStationId}/{legalQualification}")
    public ResponseEntity<List<CriminalFileResponse>> getByLegalQualificationOnPoliceStation(@PathVariable("policeStationId") Long policeStationId,
                                                                              @PathVariable("legalQualification") String legalQualification) {
        return new ResponseEntity<>(criminalFileService.findByLegalQualificationOnPoliceStation(policeStationId, legalQualification), HttpStatus.OK);
    }

    @GetMapping("/byCrimeType/{id}")
    public ResponseEntity<List<CriminalFileResponse>> getAllByCrimeType(@PathVariable("id") Long id) {
        return new ResponseEntity<>(criminalFileService.findByCrimeTypeId(id), HttpStatus.OK);
    }

    @GetMapping("/byPoliceStation-and-crime-type/{policeStationId}/{crimeTypeId}")
    public ResponseEntity<List<CriminalFileResponse>> getByCrimeTypeOnPoliceStation(@PathVariable("policeStationId") Long policeStationId,
                                                                                    @PathVariable("crimeTypeId") Long crimeTypeId) {
        return new ResponseEntity<>(criminalFileService.findByCrimeTypeIdOnPoliceStation(policeStationId, crimeTypeId), HttpStatus.OK);
    }


}
