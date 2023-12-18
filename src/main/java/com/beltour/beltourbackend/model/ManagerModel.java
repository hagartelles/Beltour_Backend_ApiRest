package com.beltour.beltourbackend.model;

import com.beltour.beltourbackend.dto.ManagerDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Entity
@Table(name="manager")
public class ManagerModel extends EntityModel{

        @Column(name ="CPF" ,nullable = false, length = 11, unique = true)
        private String cpf;

        @Column(name= "name", nullable = false)
        private String name;

        @Column(name = "telephone", nullable = false)
        private long tel;

        @Column(name ="email", nullable = false, unique = true)
        private String email;

        @Column(name = "password", nullable = false)
        private String password;

    public ManagerModel(ManagerDTO manager){

        BeanUtils.copyProperties(manager, this);
    };
    public ManagerModel(){}

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        // Verificar se a string contém apenas números
        if (cpf != null && cpf.matches("\\d+")) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF deve conter apenas números");
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getTel() {
        return tel;
    }
    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
