package com.beltour.beltourbackend.model;

import com.beltour.beltourbackend.dto.DestinationDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Destination")
public class DestinationModel extends EntityModel{

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="country", nullable = false)
    private String country;

    @Column(name="state")
    private String state;

    @Column(name="city", nullable = false)
    private String city;


    // destination - reservations
    @OneToMany(mappedBy = "destinations")
    @JsonIgnoreProperties("destinations")
    private List<ReservationModel> destinations;

    // destination - destinationTripProviders
    @OneToMany(mappedBy = "destination")
    @JsonIgnoreProperties("DestinationTripProviders")
    private List<DestinationTripProviderModel> DestinationTripProviders;

    public DestinationModel(DestinationDTO destinations) {
        BeanUtils.copyProperties(destinations, this);
    }
    public DestinationModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ReservationModel> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<ReservationModel> destinations) {
        this.destinations = destinations;
    }

    public List<DestinationTripProviderModel> getDestinationTripProviders() {
        return DestinationTripProviders;
    }

    public void setDestinationTripProviders(List<DestinationTripProviderModel> destinationTripProviders) {
        DestinationTripProviders = destinationTripProviders;
    }
}
