package com.beltour.beltourbackend.service;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.model.ClientModel;
import com.beltour.beltourbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void register(ClientDTO client) {
        ClientModel clientModel = new ClientModel(client);
        clientRepository.save(clientModel);
    }

    public ClientDTO findById(Long id){
        return new ClientDTO(clientRepository.findById(id).get());
    }
    public List<ClientDTO> findAll(){
        List<ClientModel> clients = clientRepository.findAll();
        return clients.stream().map(ClientDTO::new).toList();
    }

    public ClientDTO update(ClientDTO clientDTO){
        ClientModel clientModel = new ClientModel(clientDTO);
        return new ClientDTO(clientRepository.save(clientModel));
    }

    public void delete(Long id) {
        Optional<ClientModel> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            // O cliente foi encontrado, pode deletar
            ClientModel client = optionalClient.get();
            clientRepository.delete(client);
        } else {
            // Cliente não encontrado, lançar exceção ou lidar de outra forma
            throw new IllegalArgumentException("Cliente com ID " + id + " não encontrado");
        }
    }
}
