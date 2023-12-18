package com.beltour.beltourbackend.controller;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.dto.CustomerContactDTO;
import com.beltour.beltourbackend.service.ClientService;
import com.beltour.beltourbackend.service.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class CustomerContactController {

    @Autowired
    private CustomerContactService customerContactService;

    @GetMapping("/allContacts")
    public List<CustomerContactDTO> listAll(){
        return customerContactService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerContactDTO findByID(@PathVariable("id") Long id){
        return customerContactService.findById(id);
    }

    @PostMapping
    public void register(@RequestBody CustomerContactDTO customerContact){
        customerContactService.register(customerContact);
    }

    @PutMapping("/{id}")
    public CustomerContactDTO update(@PathVariable("id") Long id, @RequestBody CustomerContactDTO customerContactUpdate){
        CustomerContactDTO customerContactTarget = customerContactService.findById(id);
        customerContactTarget.setStatus(customerContactUpdate.getStatus() != null ? customerContactUpdate.getStatus() : customerContactTarget.getStatus());
        return customerContactService.update(customerContactTarget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        customerContactService.delete(id);
    }
}
