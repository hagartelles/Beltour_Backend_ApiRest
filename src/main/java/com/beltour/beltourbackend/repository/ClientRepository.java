package com.beltour.beltourbackend.repository;

import com.beltour.beltourbackend.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}
