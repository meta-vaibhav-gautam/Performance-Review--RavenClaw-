package com.metacube.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.tms.entity.KeyPerformanceGroupMaster;

@Repository
public interface KeyPerformanceGroupMasterRepository extends JpaRepository<KeyPerformanceGroupMaster, Long> {
}
