package com.beltour.beltourbackend.repository;

import com.beltour.beltourbackend.model.CustomerContactModel;
import com.beltour.beltourbackend.model.TripProviderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripProviderRepository extends JpaRepository<TripProviderModel, Long> {
}
