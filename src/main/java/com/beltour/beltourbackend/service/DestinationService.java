package com.beltour.beltourbackend.service;

import com.beltour.beltourbackend.dto.DestinationDTO;
import com.beltour.beltourbackend.model.DestinationModel;
import com.beltour.beltourbackend.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public void register(DestinationDTO destination) {
        DestinationModel destinationModel = new DestinationModel(destination);
        destinationRepository.save(destinationModel);
    }

    public DestinationDTO findById(Long id) {
        return new DestinationDTO(destinationRepository.findById(id).orElse(null));
    }

    public List<DestinationDTO> findAll() {
        List<DestinationModel> destinations = destinationRepository.findAll();
        return destinations.stream().map(DestinationDTO::new).toList();
    }

    public DestinationDTO update(DestinationDTO destinationDTO) {
        DestinationModel destinationModel = new DestinationModel(destinationDTO);
        return new DestinationDTO(destinationRepository.save(destinationModel));
    }

    public void delete(Long id) {
        Optional<DestinationModel> optionalDestination = destinationRepository.findById(id);

        if (optionalDestination.isPresent()) {
            // O destino foi encontrado, pode deletar
            DestinationModel destination = optionalDestination.get();
            destinationRepository.delete(destination);
        } else {
            // Destino não encontrado, lançar exceção ou lidar de outra forma
            throw new IllegalArgumentException("Destino com ID " + id + " não encontrado");
        }
    }
}
