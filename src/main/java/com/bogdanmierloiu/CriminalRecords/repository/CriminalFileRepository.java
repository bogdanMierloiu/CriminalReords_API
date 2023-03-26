package com.bogdanmierloiu.CriminalRecords.repository;

import com.bogdanmierloiu.CriminalRecords.entity.CriminalFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalFileRepository extends JpaRepository<CriminalFile, Long> {
}
