package com.beltour.beltourbackend.controller;

import com.beltour.beltourbackend.dto.DestinationDTO;
import com.beltour.beltourbackend.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/list")
    public List<DestinationDTO> listAll() {
        return destinationService.findAll();
    }

    @GetMapping("/{id}")
    public DestinationDTO findByID(@PathVariable("id") Long id) {
        return destinationService.findById(id);
    }

    @PostMapping
    public void register(@RequestBody DestinationDTO destination) {
        destinationService.register(destination);
    }

    @PutMapping("/{id}")
    public DestinationDTO update(@PathVariable("id") Long id, @RequestBody DestinationDTO destinationUpdate) {
        DestinationDTO destinationTarget = destinationService.findById(id);
        destinationTarget.setCreationDate(destinationUpdate.getCreationDate() != null ? destinationUpdate.getCreationDate() : destinationTarget.getCreationDate());
        destinationTarget.setStatus(destinationUpdate.getStatus() != null ? destinationUpdate.getStatus() : destinationTarget.getStatus());
        destinationTarget.setName(destinationUpdate.getName() != null ? destinationUpdate.getName() : destinationTarget.getName());
        destinationTarget.setCountry(destinationUpdate.getCountry() != null ? destinationUpdate.getCountry() : destinationTarget.getCountry());
        destinationTarget.setState(destinationUpdate.getState() != null ? destinationUpdate.getState() : destinationTarget.getState());
        destinationTarget.setCity(destinationUpdate.getCity() != null ? destinationUpdate.getCity() : destinationTarget.getCity());

        return destinationService.update(destinationTarget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        destinationService.delete(id);
    }
}
