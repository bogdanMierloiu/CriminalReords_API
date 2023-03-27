package com.bogdanmierloiu.CriminalRecords.controller.specific;

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
@RequestMapping("criminal-records/criminal-file-specific")
@RequiredArgsConstructor
public class CriminalFileControllerSpecific {

    private final CriminalFileService criminalFileService;

    @GetMapping("/byPoliceStation/{id}")
    public ResponseEntity<List<CriminalFileResponse>> getByPoliceStationId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(criminalFileService.findByPoliceStationId(id), HttpStatus.OK);
    }

    @GetMapping("/unknown-author/{id}")
    public ResponseEntity<List<CriminalFileResponse>> unknownAuthorByPoliceStation(@PathVariable("id") Long id) {
        return new ResponseEntity<>(criminalFileService.filesWithUnknownAuthorByPoliceStation(id), HttpStatus.OK);
    }

    @GetMapping("/byPoliceStation-and-legal-qualification/{policeStationId}/{legalQualification}")
    public ResponseEntity<List<CriminalFileResponse>> getByLegalQualificationOnPoliceStation(@PathVariable("policeStationId") Long policeStationId,
                                                                                             @PathVariable("legalQualification") String legalQualification) {
        return new ResponseEntity<>(criminalFileService.findByLegalQualificationOnPoliceStation(policeStationId, legalQualification), HttpStatus.OK);
    }

    @GetMapping("/byPoliceStation-and-crime-type/{policeStationId}/{crimeTypeId}")
    public ResponseEntity<List<CriminalFileResponse>> getByCrimeTypeOnPoliceStation(@PathVariable("policeStationId") Long policeStationId,
                                                                                    @PathVariable("crimeTypeId") Long crimeTypeId) {
        return new ResponseEntity<>(criminalFileService.findByCrimeTypeIdOnPoliceStation(policeStationId, crimeTypeId), HttpStatus.OK);
    }

    @GetMapping("/byPoliceStation-and-department/{policeStationId}/{departmentId}")
    public ResponseEntity<List<CriminalFileResponse>> getByDepartmentOnPoliceStation(@PathVariable("policeStationId") Long policeStationId,
                                                                                     @PathVariable("departmentId") Long departmentId) {
        return new ResponseEntity<>(criminalFileService.findByPoliceStationIdAndDepartmentId(policeStationId, departmentId), HttpStatus.OK);
    }

    @GetMapping("/findByDateTimeCrimeBetween/{id}")
    public ResponseEntity<List<CriminalFileResponse>> getByPoliceStationAndDateTimeCrimeBetween(@PathVariable("id") Long policeStationId,
                                                                                                @RequestBody DateTimeRequest dateTimeRequest) {
        return new ResponseEntity<>(criminalFileService.findByPoliceStationAndDateTimeCrimeBetween(policeStationId, dateTimeRequest), HttpStatus.OK);
    }


}


