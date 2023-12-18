package com.beltour.beltourbackend.dto;

import com.beltour.beltourbackend.model.ClientModel;
import com.beltour.beltourbackend.model.DestinationModel;
import com.beltour.beltourbackend.model.ManagerModel;
import com.beltour.beltourbackend.model.ReservationModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class ReservationDTO {

    private long id;
    private Date creationDate;
    private String status;
    private Date departureDate;

    @JsonProperty("clientDTO")
    private ClientDTO clientDTO;

    @JsonProperty("destinationDTO")
    private DestinationDTO destinationDTO;

    public ReservationDTO (ReservationModel reservation){
        BeanUtils.copyProperties(reservation, this);
        if(reservation.getClient() !=null){
            this.clientDTO = new ClientDTO(reservation.getClient());
        }
        if(reservation.getDestinations() !=null){
            this.destinationDTO = new DestinationDTO(reservation.getDestinations());
        }
    }
    public ReservationDTO(){}

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

    public Date getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }
    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public DestinationDTO getDestinationDTO() {
        return destinationDTO;
    }
    public void setDestinationDTO(DestinationDTO destinationDTO) {
        this.destinationDTO = destinationDTO;
    }
}
