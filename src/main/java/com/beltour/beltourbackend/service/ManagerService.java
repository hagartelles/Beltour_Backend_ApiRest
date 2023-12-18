package com.beltour.beltourbackend.service;

import com.beltour.beltourbackend.dto.ManagerDTO;
import com.beltour.beltourbackend.model.ManagerModel;
import com.beltour.beltourbackend.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public void register(ManagerDTO manager) {
        ManagerModel managerModel = new ManagerModel(manager);
        managerRepository.save(managerModel);
    }

    public ManagerDTO findById(Long id){
        return new ManagerDTO(managerRepository.findById(id).orElse(null));
    }

    public List<ManagerDTO> findAll(){
        List<ManagerModel> managers = managerRepository.findAll();
        return managers.stream().map(ManagerDTO::new).toList();
    }

    public ManagerDTO update(ManagerDTO managerDTO){
        ManagerModel managerModel = new ManagerModel(managerDTO);
        return new ManagerDTO(managerRepository.save(managerModel));
    }

    public void delete(Long id) {
        Optional<ManagerModel> optionalManager = managerRepository.findById(id);

        if (optionalManager.isPresent()) {
            // O gerente foi encontrado, pode deletar
            ManagerModel manager = optionalManager.get();
            managerRepository.delete(manager);
        } else {
            // Gerente não encontrado, lançar exceção ou lidar de outra forma
            throw new IllegalArgumentException("Gerente com ID " + id + " não encontrado");
        }
    }
}
