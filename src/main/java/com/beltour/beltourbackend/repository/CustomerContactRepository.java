package com.beltour.beltourbackend.repository;

import com.beltour.beltourbackend.model.CustomerContactModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContactRepository extends JpaRepository<CustomerContactModel, Long> {
}
