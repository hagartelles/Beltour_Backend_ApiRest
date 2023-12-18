package com.beltour.beltourbackend.controller;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.dto.DestinationDTO;
import com.beltour.beltourbackend.dto.ReservationDTO;
import com.beltour.beltourbackend.service.ClientService;
import com.beltour.beltourbackend.service.DestinationService;
import com.beltour.beltourbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    @GetMapping("/list")
    public List<ReservationDTO> listAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ReservationDTO findByID(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public void register(@RequestBody ReservationDTO reservation) {

        reservationService.register(reservation);
    }

    @PutMapping("/{id}")
    public ReservationDTO update(@PathVariable("id") Long id, @RequestBody ReservationDTO reservationUpdate) {
        ClientDTO clientDTO = reservationUpdate.getClientDTO();
        DestinationDTO destinationDTO = reservationUpdate.getDestinationDTO();

        ReservationDTO reservationTarget = reservationService.findById(id);
        reservationTarget.setCreationDate(reservationUpdate.getCreationDate() != null ? reservationUpdate.getCreationDate() : reservationTarget.getCreationDate());
        reservationTarget.setStatus(reservationUpdate.getStatus() != null ? reservationUpdate.getStatus() : reservationTarget.getStatus());
        reservationTarget.setDepartureDate(reservationUpdate.getDepartureDate() != null ? reservationUpdate.getDepartureDate() : reservationTarget.getDepartureDate());
        reservationTarget.setClientDTO(clientDTO != null ? clientDTO : reservationTarget.getClientDTO());
        reservationTarget.setDestinationDTO(destinationDTO != null ? destinationDTO : reservationTarget.getDestinationDTO());

        return reservationService.update(reservationTarget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        reservationService.delete(id);
    }

}

