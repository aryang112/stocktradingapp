package com.example.stocktradingapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

public class UserRequestDTO {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Size(min = 9, max = 9, message = "Invalid SSN")
    private String ssn;
    private String email;
    private LocalDate dateOfBirth;



    public UserRequestDTO() {
    }

    public UserRequestDTO(String firstName, String lastName, String ssn, String email, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserRequestDTO firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public UserRequestDTO lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public UserRequestDTO ssn(String ssn) {
        setSsn(ssn);
        return this;
    }

    public UserRequestDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UserRequestDTO dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserRequestDTO)) {
            return false;
        }
        UserRequestDTO userRequestDTO = (UserRequestDTO) o;
        return Objects.equals(firstName, userRequestDTO.firstName) && Objects.equals(lastName, userRequestDTO.lastName) && Objects.equals(ssn, userRequestDTO.ssn) && Objects.equals(email, userRequestDTO.email) && Objects.equals(dateOfBirth, userRequestDTO.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ssn, email, dateOfBirth);
    }

    @Override
    public String toString() {
        return "{" +
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", ssn='" + getSsn() + "'" +
            ", email='" + getEmail() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            "}";
    }
    
    
}
