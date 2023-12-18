package com.beltour.beltourbackend.controller;

import com.beltour.beltourbackend.dto.CustomerContactDTO;
import com.beltour.beltourbackend.dto.TripProviderDTO;
import com.beltour.beltourbackend.service.CustomerContactService;
import com.beltour.beltourbackend.service.TripProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TripProvider")
public class TripProviderController {

    @Autowired
    private TripProviderService tripProviderService;

    @GetMapping("/allProviders")
    public List<TripProviderDTO> listAll() {
        return tripProviderService.findAll();
    }

    @GetMapping("/{id}")
    public TripProviderDTO findByID(@PathVariable("id") Long id) {
        return tripProviderService.findById(id);
    }

    @PostMapping
    public void register(@RequestBody TripProviderDTO tripProvider) {
        tripProviderService.register(tripProvider);
    }

    @PutMapping("/{id}")
    public TripProviderDTO update(@PathVariable("id") Long id, @RequestBody TripProviderDTO tripProviderUpdate) {
        TripProviderDTO tripProviderTarget = tripProviderService.findById(id);
        tripProviderTarget.setStatus(tripProviderUpdate.getStatus() != null ? tripProviderUpdate.getStatus() : tripProviderTarget.getStatus());
        tripProviderTarget.setTransportType(tripProviderUpdate.getTransportType() != null ? tripProviderUpdate.getTransportType() : tripProviderTarget.getTransportType());
        tripProviderTarget.setAddress(tripProviderUpdate.getAddress() != null ? tripProviderUpdate.getAddress() : tripProviderTarget.getAddress());
        tripProviderTarget.setCnpj(tripProviderUpdate.getCnpj() != null ? tripProviderUpdate.getCnpj() : tripProviderTarget.getCnpj());
        tripProviderTarget.setEmail(tripProviderUpdate.getEmail() != null ? tripProviderUpdate.getEmail() : tripProviderTarget.getEmail());
        tripProviderTarget.setName(tripProviderUpdate.getName() != null ? tripProviderUpdate.getName() : tripProviderTarget.getName());
        tripProviderTarget.setTel(tripProviderUpdate.getTel() != 0L ? tripProviderUpdate.getTel() : tripProviderTarget.getTel());
        return tripProviderService.update(tripProviderTarget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        tripProviderService.delete(id);
    }
}


