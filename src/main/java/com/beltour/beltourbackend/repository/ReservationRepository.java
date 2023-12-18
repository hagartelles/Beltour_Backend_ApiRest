package com.beltour.beltourbackend.repository;

import com.beltour.beltourbackend.model.CustomerContactModel;
import com.beltour.beltourbackend.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationModel, Long> {
}
