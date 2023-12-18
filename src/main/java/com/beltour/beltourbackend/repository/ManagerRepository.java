package com.beltour.beltourbackend.repository;

import com.beltour.beltourbackend.model.CustomerContactModel;
import com.beltour.beltourbackend.model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerModel, Long> {
}
