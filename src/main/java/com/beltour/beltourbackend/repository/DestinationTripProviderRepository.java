package com.beltour.beltourbackend.repository;

import com.beltour.beltourbackend.model.DestinationTripProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationTripProviderRepository extends JpaRepository<DestinationTripProviderModel, Long> {
}
