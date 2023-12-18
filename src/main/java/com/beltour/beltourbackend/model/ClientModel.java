package com.beltour.beltourbackend.model;

import com.beltour.beltourbackend.dto.ClientDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;

@Entity
@Table(name="client")
public class ClientModel extends EntityModel{

    @Column(name ="CPF" ,nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name="born_date", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date bornDate;
    @Column(name = "telephone", nullable = false)
    private long tel;

    @Column(name ="address")
    private String address;

    @Column(name ="email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<ReservationModel> reservations;

    public ClientModel(ClientDTO client){
        BeanUtils.copyProperties(client, this);
    };
    public ClientModel(){}

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        // Remover caracteres não numéricos do CPF
        String cleanedCpf = cpf.replaceAll("[^0-9]", "");

        // Agora, você pode verificar se cleanedCpf é composto apenas por números antes de atribuir ao atributo cpf.
        if (cleanedCpf.matches("\\d+")) {
            this.cpf = cleanedCpf;
        } else {
            // Lançar uma exceção ou realizar outra ação apropriada em caso de CPF inválido.
            throw new IllegalArgumentException("CPF deve conter apenas números");
        }
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

    public List<ReservationModel> getReservations() {
        return reservations;
    }
    public void setReservations(List<ReservationModel> reservations) {
        this.reservations = reservations;
    }



    @Override
    public String toString() {
        return "Client [password=" + password
                + ", getId()=" + getId()
                + ", getPassword()=" + getPassword()
                + ", getName()=" + getName()
                + ", getCpf()=" + getCpf()
                + ", getBornDate()=" + getBornDate()
                + ", getTel()=" + getTel()
                + ", getEmail()=" + getEmail()
                + ", getAddress()=" + getAddress()
                + ", getCreationDate" + getCreationDate()
                + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + "]";
    }
}
