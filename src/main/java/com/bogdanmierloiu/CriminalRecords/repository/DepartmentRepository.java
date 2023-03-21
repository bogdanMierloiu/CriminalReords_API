package com.bogdanmierloiu.CriminalRecords.repository;

import com.bogdanmierloiu.CriminalRecords.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
