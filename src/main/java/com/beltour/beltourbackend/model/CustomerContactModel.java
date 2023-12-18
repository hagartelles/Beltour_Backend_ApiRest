package com.beltour.beltourbackend.model;

import com.beltour.beltourbackend.dto.CustomerContactDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="customer_contact")
public class CustomerContactModel extends EntityModel{

    @Column(name="Name" , nullable = false)
    private String Name;

    @Column(name="email" , nullable = false)
    private String email;

    @Column(name="message" , nullable = false)
    private String message;

    @Column(name="tel")
    private Long telephone;

    public CustomerContactModel(CustomerContactDTO client){

        BeanUtils.copyProperties(client, this);
    };
    public CustomerContactModel(){}

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
}
