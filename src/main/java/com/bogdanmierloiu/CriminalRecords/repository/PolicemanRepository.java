package com.bogdanmierloiu.CriminalRecords.repository;

import com.bogdanmierloiu.CriminalRecords.entity.Policeman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicemanRepository extends JpaRepository<Policeman, Long> {

    List<Policeman> findByPoliceStationId(Long id);
}
