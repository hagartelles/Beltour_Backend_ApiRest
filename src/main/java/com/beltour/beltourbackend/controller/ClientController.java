package com.beltour.beltourbackend.controller;

import java.util.List;

import ch.qos.logback.core.net.server.Client;
import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public List<ClientDTO> listAll(){
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findByID(@PathVariable("id") Long id){
        return clientService.findById(id);
    }

    @PostMapping
    public void register(@RequestBody ClientDTO client){
        clientService.register(client);
    }

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable("id") Long id, @RequestBody ClientDTO clientUpdate){
        ClientDTO clientTarget = clientService.findById(id);
        clientTarget.setName(clientUpdate.getName() != null ? clientUpdate.getName() : clientTarget.getName());
        clientTarget.setAddress(clientUpdate.getAddress() != null ? clientUpdate.getAddress() : clientTarget.getAddress());
        clientTarget.setCpf(clientUpdate.getCpf() != null ? clientUpdate.getCpf() : clientTarget.getCpf());
        clientTarget.setTel(clientUpdate.getTel() != 0L ? clientUpdate.getTel() : clientTarget.getTel());
        clientTarget.setBornDate(clientUpdate.getBornDate() != null ? clientUpdate.getBornDate() : clientTarget.getBornDate());
        clientTarget.setStatus(clientUpdate.getStatus() != null ? clientUpdate.getStatus() : clientTarget.getStatus());
        clientTarget.setPassword(clientUpdate.getPassword() != null ? clientUpdate.getPassword() : clientTarget.getPassword());
        clientTarget.setEmail(clientUpdate.getEmail() != null ? clientUpdate.getEmail() : clientTarget.getEmail());

        return clientService.update(clientTarget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        clientService.delete(id);
    }
}
