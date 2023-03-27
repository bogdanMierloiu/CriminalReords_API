package com.bogdanmierloiu.CriminalRecords.repository;

import com.bogdanmierloiu.CriminalRecords.entity.CriminalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CriminalFileRepository extends JpaRepository<CriminalFile, Long> {

    List<CriminalFile> findByPoliceStationId(Long id);

    @Query("SELECT cf FROM CriminalFile cf LEFT JOIN cf.authors a WHERE cf.policeStation.id = :id AND (a IS NULL OR size(cf.authors) = 0)")
    List<CriminalFile> findFilesWithUnknownAuthor(@Param("id") Long id);

    CriminalFile findByNumber(Long number);

    List<CriminalFile> findByLegalQualificationContainingIgnoreCase(String legalQualification);

    List<CriminalFile> findByPoliceStationIdAndLegalQualificationContainingIgnoreCase(Long policeStationId, String legalQualification);

    List<CriminalFile> findByCrimeTypeId(Long id);

    List<CriminalFile> findByPoliceStationIdAndCrimeTypeId(Long policeStationId, Long crimeTypeId);

    List<CriminalFile> findByPoliceStationIdAndDepartmentId(Long policeStationId, Long DepartmentId);

    List<CriminalFile> findByPolicemanId(Long id);

    List<CriminalFile> findByDateTimeCrimeBetween(LocalDateTime dateFrom, LocalDateTime dateTo);

    List<CriminalFile> findByPoliceStationIdAndDateTimeCrimeBetween(Long policeStationId, LocalDateTime dateFrom, LocalDateTime dateTo);

    List<CriminalFile> findByRegistrationDateBetween(LocalDate dateFrom, LocalDate dateTo);

}
