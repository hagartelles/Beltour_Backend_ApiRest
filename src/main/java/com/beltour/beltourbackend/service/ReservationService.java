package com.beltour.beltourbackend.service;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.dto.DestinationDTO;
import com.beltour.beltourbackend.dto.ReservationDTO;
import com.beltour.beltourbackend.model.ClientModel;
import com.beltour.beltourbackend.model.DestinationModel;
import com.beltour.beltourbackend.model.ReservationModel;
import com.beltour.beltourbackend.repository.ClientRepository;
import com.beltour.beltourbackend.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired private ReservationRepository reservationRepository;
    @Autowired private ClientService clientService;
    @Autowired private DestinationService destinationService;

    public void register(ReservationDTO reservation) {
        ReservationModel reservationModel = new ReservationModel(reservation);
        setDestinationAndClient(reservationModel, reservation.getClientDTO().getId(), reservation.getDestinationDTO().getId());
        reservationRepository.save(reservationModel);
    }

    public ReservationDTO findById(Long id) {
        return new ReservationDTO(reservationRepository.findById(id).orElse(null));
    }

    public List<ReservationDTO> findAll() {
        List<ReservationModel> reservations = reservationRepository.findAll();
        return reservations.stream().map(ReservationDTO::new).toList();
    }

    public ReservationDTO update(ReservationDTO reservationDTO) {
        ReservationModel reservationModel = new ReservationModel(reservationDTO);
        setDestinationAndClient(reservationModel, reservationDTO.getClientDTO().getId(), reservationDTO.getDestinationDTO().getId());
        return new ReservationDTO(reservationRepository.save(reservationModel));
    }

    public void delete(Long id) {
        Optional<ReservationModel> optionalReservation = reservationRepository.findById(id);

        if (optionalReservation.isPresent()) {
            // A reserva foi encontrada, pode deletar
            ReservationModel reservation = optionalReservation.get();
            reservationRepository.delete(reservation);
        } else {
            // Reserva não encontrada, lançar exceção ou lidar de outra forma
            throw new IllegalArgumentException("Reserva com ID " + id + " não encontrada");
        }
    }

    private void setDestinationAndClient(ReservationModel reservationModel, long idClient, long idDestination) {
        ClientDTO clientDTO = clientService.findById(idClient);
        DestinationDTO destinationDTO = destinationService.findById(idDestination);

        ClientModel clientModel = new ClientModel(clientDTO);
        DestinationModel destinationModel = new DestinationModel(destinationDTO);

        reservationModel.setClient(clientModel);
        reservationModel.setDestinations(destinationModel);
    }
}
