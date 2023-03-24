package com.bogdanmierloiu.CriminalRecords.repository;

import com.bogdanmierloiu.CriminalRecords.entity.CrimeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeTypeRepository extends JpaRepository<CrimeType, Long> {
}
