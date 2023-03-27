package com.bogdanmierloiu.CriminalRecords.controller.global;

import com.bogdanmierloiu.CriminalRecords.controller.CrudController;
import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileRequest;
import com.bogdanmierloiu.CriminalRecords.dto.criminal_file.CriminalFileResponse;
import com.bogdanmierloiu.CriminalRecords.dto.date.DateRequest;
import com.bogdanmierloiu.CriminalRecords.dto.date.DateTimeRequest;
import com.bogdanmierloiu.CriminalRecords.service.CriminalFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("criminal-records/criminal-file")
@RequiredArgsConstructor
public class CriminalFileControllerGlobal implements CrudController<CriminalFileRequest, CriminalFileResponse> {

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

    @GetMapping("/byNumber/{number}")
    public ResponseEntity<CriminalFileResponse> getByNumber(@PathVariable("number") Long number) {
        return new ResponseEntity<>(criminalFileService.findByNumber(number), HttpStatus.OK);
    }

    @GetMapping("/byLegalQualification/{legalQualification}")
    public ResponseEntity<List<CriminalFileResponse>> getByLegalQualification(@PathVariable("legalQualification") String legalQualification) {
        return new ResponseEntity<>(criminalFileService.findByLegalQualification(legalQualification), HttpStatus.OK);
    }

    @GetMapping("/byCrimeType/{id}")
    public ResponseEntity<List<CriminalFileResponse>> getAllByCrimeType(@PathVariable("id") Long id) {
        return new ResponseEntity<>(criminalFileService.findByCrimeTypeId(id), HttpStatus.OK);
    }

    @GetMapping("/byPoliceman/{policemanId}")
    public ResponseEntity<List<CriminalFileResponse>> getByPoliceman(@PathVariable("policemanId") Long policemanId) {
        return new ResponseEntity<>(criminalFileService.findByPolicemanId(policemanId), HttpStatus.OK);
    }

    @GetMapping("/findByDateTimeCrimeBetween")
    public ResponseEntity<List<CriminalFileResponse>> getByDateTimeCrimeBetween(@RequestBody DateTimeRequest dateTimeRequest) {
        return new ResponseEntity<>(criminalFileService.findByDateTimeCrimeBetween(dateTimeRequest), HttpStatus.OK);
    }

    @GetMapping("/findByDateCrime/{date}")
    public ResponseEntity<List<CriminalFileResponse>> getByDateCrime(@PathVariable("date") LocalDate date) {
        return new ResponseEntity<>(criminalFileService.findByDateCrime(date), HttpStatus.OK);
    }

    @GetMapping("/findByRegistrationDateBetween")
    public ResponseEntity<List<CriminalFileResponse>> getByRegistrationDateBetween(@RequestBody DateRequest dateRequest) {
        return new ResponseEntity<>(criminalFileService.findByRegistrationDateBetween(dateRequest), HttpStatus.OK);
    }

    @GetMapping("/findByRegistrationDate/{date}")
    public ResponseEntity<List<CriminalFileResponse>> getByRegistrationDate(@PathVariable("date") LocalDate date) {
        return new ResponseEntity<>(criminalFileService.findByRegistrationDate(date), HttpStatus.OK);
    }


}


