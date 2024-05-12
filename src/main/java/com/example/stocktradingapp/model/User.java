package com.example.stocktradingapp.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "app_user")
public class User {

    @jakarta.persistence.Id
    private UUID Id;
    
    private String firstName;
    private String lastName;
    private String status;
    private String ssn;
    private LocalDate dateOfBirth;


    public User() {
    }

    public User(UUID Id, String firstName, String lastName, String status, String ssn, LocalDate dateOfBirth) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.ssn = ssn;
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

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User Id(UUID Id) {
        setId(Id);
        return this;
    }

    public User firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public User lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public User status(String status) {
        setStatus(status);
        return this;
    }

    public User ssn(String ssn) {
        setSsn(ssn);
        return this;
    }

    public User dateOfBirth(LocalDate dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(Id, user.Id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(status, user.status) && Objects.equals(ssn, user.ssn) && Objects.equals(dateOfBirth, user.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, status, ssn, dateOfBirth);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", status='" + getStatus() + "'" +
            ", ssn='" + getSsn() + "'" +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            "}";
    }

    
    
}
