package com.beltour.beltourbackend.model;

import com.beltour.beltourbackend.dto.DestinationDTO;
import com.beltour.beltourbackend.dto.DestinationTripProviderDTO;
import com.beltour.beltourbackend.dto.TripProviderDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.print.attribute.standard.Destination;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Destination_TripProvider")
public class DestinationTripProviderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="destination_id")
    @JsonIgnoreProperties("DestinationTripProviders")
    private DestinationModel destination;

    @ManyToOne
    @JoinColumn(name ="tripProvider_id")
    @JsonIgnoreProperties("DestinationTripProviders")
    private TripProviderModel tripProviders;

    public DestinationTripProviderModel(DestinationTripProviderDTO destinationTripProvider) {
        BeanUtils.copyProperties( this, destinationTripProvider);
    }

    public DestinationTripProviderModel() {

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public DestinationModel getDestination() {
        return destination;
    }
    public void setDestination(DestinationModel destination) {
        this.destination = destination;
    }

    public TripProviderModel getTripProviders() {
        return tripProviders;
    }
    public void setTripProviders(TripProviderModel tripProviders) {
        this.tripProviders = tripProviders;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DestinationTripProviderModel other = (DestinationTripProviderModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s [id=%d]", this.getClass().getName(), getId());
    }

}