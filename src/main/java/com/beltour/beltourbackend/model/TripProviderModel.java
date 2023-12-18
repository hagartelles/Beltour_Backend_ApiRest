package com.beltour.beltourbackend.model;

import com.beltour.beltourbackend.dto.TripProviderDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name="Trip_Provider")
public class TripProviderModel extends EntityModel{

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="cnpj", nullable = false, unique = true)
    private String cnpj;

    @Column(name="Transport_type")
    private String TransportType;

    @Column(name="address")
    private String address;

    @Column(name = "telephone", nullable = false)
    private long tel;

    @Column(name ="email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "tripProviders")
    @JsonIgnoreProperties("DestinationTripProviders")
    private List<DestinationTripProviderModel> DestinationTripProviders;

    public TripProviderModel(TripProviderDTO tripProvider) {
        BeanUtils.copyProperties(tripProvider, this);
    }

    public TripProviderModel() {}

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

    public List<DestinationTripProviderModel> getDestinationTripProviders() {
        return DestinationTripProviders;
    }

    public void setDestinationTripProviders(List<DestinationTripProviderModel> destinationTripProviders) {
        DestinationTripProviders = destinationTripProviders;
    }
}
