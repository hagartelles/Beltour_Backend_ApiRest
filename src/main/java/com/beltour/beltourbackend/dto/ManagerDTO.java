package com.beltour.beltourbackend.dto;

import com.beltour.beltourbackend.model.DestinationModel;
import com.beltour.beltourbackend.model.ManagerModel;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class ManagerDTO {

    private long id;
    private Date creationDate;
    private String status;
    private String cpf;
    private String name;
    private long tel;
    private String email;
    private String password;

    public ManagerDTO(ManagerModel manager){

        BeanUtils.copyProperties(manager, this);
    };
    public ManagerDTO(){}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
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
