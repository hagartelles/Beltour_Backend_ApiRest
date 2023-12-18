package com.beltour.beltourbackend.service;

import com.beltour.beltourbackend.dto.TripProviderDTO;
import com.beltour.beltourbackend.model.TripProviderModel;
import com.beltour.beltourbackend.repository.TripProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripProviderService {

    @Autowired
    private TripProviderRepository tripProviderRepository;

    public void register(TripProviderDTO tripProvider) {
        TripProviderModel tripProviderModel = new TripProviderModel(tripProvider);
        tripProviderRepository.save(tripProviderModel);
    }

    public TripProviderDTO findById(Long id){
        return new TripProviderDTO(tripProviderRepository.findById(id).orElse(null));
    }

    public List<TripProviderDTO> findAll(){
        List<TripProviderModel> tripProviders = tripProviderRepository.findAll();
        return tripProviders.stream().map(TripProviderDTO::new).toList();
    }

    public TripProviderDTO update(TripProviderDTO tripProviderDTO){
        TripProviderModel tripProviderModel = new TripProviderModel(tripProviderDTO);
        return new TripProviderDTO(tripProviderRepository.save(tripProviderModel));
    }

    public void delete(Long id) {
        Optional<TripProviderModel> optionalTripProvider = tripProviderRepository.findById(id);

        if (optionalTripProvider.isPresent()) {
            // O provedor de viagem foi encontrado, pode deletar
            TripProviderModel tripProvider = optionalTripProvider.get();
            tripProviderRepository.delete(tripProvider);
        } else {
            // Provedor de viagem não encontrado, lançar exceção ou lidar de outra forma
            throw new IllegalArgumentException("Provedor de viagem com ID " + id + " não encontrado");
        }
    }
}
