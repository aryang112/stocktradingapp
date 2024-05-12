package com.example.stocktradingapp.dto;

import java.util.UUID;

import com.example.stocktradingapp.model.UserStatus;

import java.time.LocalDate;
import java.util.Objects;

public class UserResponseDTO {

    private UUID Id;
    private String firstName;
    private String ssn;
    private String lastName;

    private UserStatus status;
    private LocalDate dateOfBirth;
    

    public UserResponseDTO() {
    }

    public UserResponseDTO(UUID Id, String firstName, String ssn, String lastName, UserStatus status, LocalDate dateOfBirth) {
        this.Id = Id;
        this.firstName = firstName;
        this.ssn = ssn;
        this.lastName = lastName;
        this.status = status;
        this.dateOfBirth = dateOfBirth;
    }

    public UUID getId() {
        return this.Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserStatus getStatus() {
        return this.status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserResponseDTO Id(UUID Id) {
        setId(Id);
        return this;
    }

    public UserResponseDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserResponseDTO ssn(String ssn) {
        setSsn(ssn);
        return this;
    }

    public UserResponseDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserResponseDTO status(UserStatus status) {
        setStatus(status);
        return this;
    }

    public UserResponseDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserResponseDTO)) {
            return false;
        }
        UserResponseDTO userResponseDTO = (UserResponseDTO) o;
        return Objects.equals(Id, userResponseDTO.Id) && Objects.equals(firstName, userResponseDTO.firstName) && Objects.equals(ssn, userResponseDTO.ssn) && Objects.equals(lastName, userResponseDTO.lastName) && Objects.equals(status, userResponseDTO.status) && Objects.equals(dateOfBirth, userResponseDTO.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, ssn, lastName, status, dateOfBirth);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", ssn='" + getSsn() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", status='" + getStatus() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            "}";
    }


    
    
}
