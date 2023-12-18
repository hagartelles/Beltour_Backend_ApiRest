package com.beltour.beltourbackend.dto;

import com.beltour.beltourbackend.model.DestinationModel;
import com.beltour.beltourbackend.model.TripProviderModel;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TripProviderDTO {

    private long id;
    private Date creationDate;
    private String status;
    private String name;

    private String cnpj;

    private String TransportType;

    private String address;

    private long tel;

    private String email;

    public TripProviderDTO(TripProviderModel tripProvider){

        BeanUtils.copyProperties(tripProvider, this);
    }
    public TripProviderDTO() {
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTransportType() {
        return TransportType;
    }

    public void setTransportType(String transportType) {
        TransportType = transportType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
