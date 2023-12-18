package com.beltour.beltourbackend.dto;

import com.beltour.beltourbackend.model.ClientModel;
import com.beltour.beltourbackend.model.ManagerModel;
import com.beltour.beltourbackend.model.ReservationModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.print.attribute.standard.Destination;
import java.util.Date;
import java.util.List;


public class ClientDTO {
    private long id;
    private String cpf;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date bornDate;
    private long tel;
    private String address;
    private String email;
    private String password;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date creationDate;
    private String status;
    private long reservationId;

    public ClientDTO(ClientModel clientModel){

        BeanUtils.copyProperties(clientModel, this);
    };

    public ClientDTO() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getBornDate() {
        return bornDate;
    }
    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public long getTel() {
        return tel;
    }
    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

    public long getReservationId() {
        return reservationId;
    }
    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }
}
