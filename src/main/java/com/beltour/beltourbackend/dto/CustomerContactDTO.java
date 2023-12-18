package com.beltour.beltourbackend.dto;

import com.beltour.beltourbackend.model.CustomerContactModel;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CustomerContactDTO {

    private long id;
    private Date creationDate;
    private String status;



    private String Name;

    private String email;

    private String message;

    private Long telephone;

    public CustomerContactDTO(CustomerContactModel customerContact){

        BeanUtils.copyProperties(customerContact, this);
    };
    public CustomerContactDTO(){}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTelephone() {
        return telephone;
    }
    public void setTelephone(Long telephone) {
        this.telephone = telephone;
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
}
