package com.beltour.beltourbackend.controller;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.dto.DestinationDTO;
import com.beltour.beltourbackend.dto.DestinationTripProviderDTO;
import com.beltour.beltourbackend.dto.TripProviderDTO;
import com.beltour.beltourbackend.service.DestinationTripProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinationTripProviders")
public class DestinationTripProviderController {

    @Autowired
    private DestinationTripProvidersService destinationTripProviderService;

    @GetMapping("/list")
    public List<DestinationTripProviderDTO> listAll() {
        return destinationTripProviderService.findAll();
    }

    @GetMapping("/{id}")
    public DestinationTripProviderDTO findByID(@PathVariable("id") Long id) {
        return destinationTripProviderService.findById(id);
    }

    @PostMapping
    public void register(@RequestBody DestinationTripProviderDTO destinationTripProvider) {
        destinationTripProviderService.register(destinationTripProvider);
    }

    @PutMapping("/{id}")
    public DestinationTripProviderDTO update(@PathVariable("id") Long id, @RequestBody DestinationTripProviderDTO destinationTripProviderUpdate) {
        DestinationDTO destinationDTO = destinationTripProviderUpdate.getDestination();
        TripProviderDTO tripProviderDTO = destinationTripProviderUpdate.getTripProvider();
        DestinationTripProviderDTO destinationTripProviderTarget = destinationTripProviderService.findById(id);
        destinationTripProviderUpdate.setTripProvider(tripProviderDTO != null ? tripProviderDTO : destinationTripProviderUpdate.getTripProvider());
        destinationTripProviderUpdate.setDestination(destinationDTO != null ? destinationDTO : destinationTripProviderUpdate.getDestination());
        return destinationTripProviderService.update(destinationTripProviderTarget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        destinationTripProviderService.delete(id);
    }
}
