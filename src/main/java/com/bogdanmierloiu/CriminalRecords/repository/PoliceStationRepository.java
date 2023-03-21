package com.bogdanmierloiu.CriminalRecords.repository;

import com.bogdanmierloiu.CriminalRecords.entity.PoliceStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long> {
}
