package com.beltour.beltourbackend.repository;

import com.beltour.beltourbackend.model.CustomerContactModel;
import com.beltour.beltourbackend.model.DestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<DestinationModel, Long> {
}
