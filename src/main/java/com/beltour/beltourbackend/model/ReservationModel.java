package com.beltour.beltourbackend.model;


import com.beltour.beltourbackend.dto.ClientDTO;
import com.beltour.beltourbackend.dto.DestinationDTO;
import com.beltour.beltourbackend.dto.ReservationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;

@Entity
@Table(name="Reservation")
public class ReservationModel extends EntityModel{

    @Column(name="departure_date" ,nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name ="client_id")
    @JsonIgnoreProperties("reservations")
    private ClientModel client;

    @ManyToOne
    @JoinColumn(name ="destination_id")
    @JsonIgnoreProperties("destinations")
    private DestinationModel destinations;

    public ReservationModel(ReservationDTO reservation) {
        BeanUtils.copyProperties(reservation, this);
    };
    public ReservationModel(){};

    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public ClientModel getClient() {
        return client;
    }
    public void setClient(ClientModel client) {
        this.client = client;
    }

    public DestinationModel getDestinations() {
        return destinations;
    }
    public void setDestinations(DestinationModel destinations) {
        this.destinations = destinations;
    }
}
