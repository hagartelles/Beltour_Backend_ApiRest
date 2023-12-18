package com.beltour.beltourbackend.service;

import com.beltour.beltourbackend.dto.*;
import com.beltour.beltourbackend.model.*;
import com.beltour.beltourbackend.repository.DestinationTripProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationTripProvidersService {

    @Autowired
    private DestinationTripProviderRepository destinationTripProviderRepository;
    @Autowired private DestinationService destinationService;
    @Autowired private TripProviderService tripProviderService;

    public void register(DestinationTripProviderDTO destinationTripProvider) {
        DestinationTripProviderModel destinationTripProviderModel = new DestinationTripProviderModel(destinationTripProvider);
        setDestinationAndTripProvider(destinationTripProviderModel, destinationTripProvider.getTripProvider().getId(), destinationTripProvider.getDestination().getId());
        destinationTripProviderRepository.save(destinationTripProviderModel);
    }

    public DestinationTripProviderDTO findById(Long id) {
        return new DestinationTripProviderDTO(destinationTripProviderRepository.findById(id).orElse(null));
    }

    public List<DestinationTripProviderDTO> findAll() {
        List<DestinationTripProviderModel> destinationTripProvider = destinationTripProviderRepository.findAll();
        return destinationTripProvider.stream().map(DestinationTripProviderDTO::new).toList();
    }

    public DestinationTripProviderDTO update(DestinationTripProviderDTO destinationTripProviderDTO) {
        DestinationTripProviderModel destinationTripProviderModel = new DestinationTripProviderModel(destinationTripProviderDTO);
        setDestinationAndTripProvider(destinationTripProviderModel, destinationTripProviderDTO.getTripProvider().getId(), destinationTripProviderDTO.getDestination().getId());
        return new DestinationTripProviderDTO(destinationTripProviderRepository.save(destinationTripProviderModel));
    }


    public void delete(Long id) {
        Optional<DestinationTripProviderModel> optionalDestinationTripProviderM = destinationTripProviderRepository.findById(id);

        if (optionalDestinationTripProviderM.isPresent()) {
            DestinationTripProviderModel DestinationTripProviderM = optionalDestinationTripProviderM.get();
            destinationTripProviderRepository.delete(DestinationTripProviderM);
        } else {
            throw new IllegalArgumentException("ID " + id + " não encontrada");
        }
    }

    private void setDestinationAndTripProvider(DestinationTripProviderModel destinationTripProviderModel, long idTripProvider, long idDestination) {
        TripProviderDTO tripProviderDTO = tripProviderService.findById(idTripProvider);
        DestinationDTO destinationDTO = destinationService.findById(idDestination);

        TripProviderModel tripProviderModel = new TripProviderModel(tripProviderDTO);
        DestinationModel destinationModel = new DestinationModel(destinationDTO);

        destinationTripProviderModel.setTripProviders(tripProviderModel);
        destinationTripProviderModel.setDestination(destinationModel);
    }
}
