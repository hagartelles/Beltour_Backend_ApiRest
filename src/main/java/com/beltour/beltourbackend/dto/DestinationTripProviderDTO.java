package com.beltour.beltourbackend.dto;

import com.beltour.beltourbackend.model.DestinationTripProviderModel;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.beans.Beans;

public class DestinationTripProviderDTO {

    private Long id;
    private DestinationDTO destination;
    private TripProviderDTO tripProvider;



    public DestinationTripProviderDTO(DestinationTripProviderModel destinationTripProvider) {
        BeanUtils.copyProperties(destinationTripProvider, this);
        if(destinationTripProvider.getTripProviders() !=null){
            this.tripProvider = new TripProviderDTO(destinationTripProvider.getTripProviders());
        }
        if(destinationTripProvider.getDestination() !=null){
            this.destination = new DestinationDTO(destinationTripProvider.getDestination());
        }
    }
    public DestinationTripProviderDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public DestinationDTO getDestination() {
        return destination;
    }
    public void setDestination(DestinationDTO destination) {
        this.destination = destination;
    }

    public TripProviderDTO getTripProvider() {
        return tripProvider;
    }
    public void setTripProvider(TripProviderDTO tripProvider) {
        this.tripProvider = tripProvider;
    }
}
