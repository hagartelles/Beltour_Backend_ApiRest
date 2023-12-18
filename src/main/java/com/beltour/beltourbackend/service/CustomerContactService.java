package com.beltour.beltourbackend.service;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.dto.CustomerContactDTO;
import com.beltour.beltourbackend.model.ClientModel;
import com.beltour.beltourbackend.model.CustomerContactModel;
import com.beltour.beltourbackend.repository.ClientRepository;
import com.beltour.beltourbackend.repository.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerContactService {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    public void register(CustomerContactDTO customerContact) {
        CustomerContactModel customerContactModel = new CustomerContactModel(customerContact);
        customerContactRepository.save(customerContactModel);
    }

    public CustomerContactDTO findById(Long id){
        return new CustomerContactDTO(customerContactRepository.findById(id).get());
    }
    public List<CustomerContactDTO> findAll(){
        List<CustomerContactModel> customerContacts = customerContactRepository.findAll();
        return customerContacts.stream().map(CustomerContactDTO::new).toList();
    }

    public CustomerContactDTO update(CustomerContactDTO customerContact){
        CustomerContactModel customerContactModel = new CustomerContactModel(customerContact);
        return new CustomerContactDTO(customerContactRepository.save(customerContactModel));
    }

    public void delete(Long id) {
        Optional<CustomerContactModel> optionalCustomerContact = customerContactRepository.findById(id);
        if (optionalCustomerContact.isPresent()) {
            CustomerContactModel customerContact = optionalCustomerContact.get();
            customerContactRepository.delete(customerContact);
        } else {
            throw new IllegalArgumentException("Contato com ID " + id + " não encontrado");
        }
    }


}
