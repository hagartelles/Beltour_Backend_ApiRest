package com.beltour.beltourbackend.dto;

import com.beltour.beltourbackend.model.DestinationModel;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class DestinationDTO {

        private long id;
        private Date creationDate;
        private String status;
        private String name;
        private String country;
        private String state;
        private String city;

    public DestinationDTO(DestinationModel destinations){
        BeanUtils.copyProperties(destinations, this);
    }

    public DestinationDTO(){}


    // Getters e Setters

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


 }

