package com.beltour.beltourbackend.controller;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.dto.ManagerDTO;
import com.beltour.beltourbackend.service.ClientService;
import com.beltour.beltourbackend.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/all")
    public List<ManagerDTO> listAll(){
        return managerService.findAll();
    }

    @GetMapping("/{id}")
    public ManagerDTO findByID(@PathVariable("id") Long id){
        return managerService.findById(id);
    }

    @PostMapping
    public void register(@RequestBody ManagerDTO manager){
        managerService.register(manager);
    }

    @PutMapping("/{id}")
    public ManagerDTO update(@PathVariable("id") Long id, @RequestBody ManagerDTO managerUpdate){
        ManagerDTO managerTarget = managerService.findById(id);
        managerTarget.setName(managerUpdate.getName() != null ? managerUpdate.getName() : managerTarget.getName());
        managerTarget.setCpf(managerUpdate.getCpf() != null ? managerUpdate.getCpf() : managerTarget.getCpf());
        managerTarget.setTel(managerUpdate.getTel() != 0L ? managerUpdate.getTel() : managerTarget.getTel());
        managerTarget.setStatus(managerUpdate.getStatus() != null ? managerUpdate.getStatus() : managerTarget.getStatus());
        managerTarget.setPassword(managerUpdate.getPassword() != null ? managerUpdate.getPassword() : managerTarget.getPassword());
        managerTarget.setEmail(managerUpdate.getEmail() != null ? managerUpdate.getEmail() : managerTarget.getEmail());

        return managerService.update(managerTarget);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        managerService.delete(id);
    }

}
