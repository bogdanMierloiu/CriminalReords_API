package com.bogdanmierloiu.CriminalRecords.repository;

import com.bogdanmierloiu.CriminalRecords.entity.Policeman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicemanRepository extends JpaRepository<Policeman, Long> {
}
