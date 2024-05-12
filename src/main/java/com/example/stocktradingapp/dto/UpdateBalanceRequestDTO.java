package com.example.stocktradingapp.dto;
import java.util.Objects;

import com.example.stocktradingapp.model.OperationType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpdateBalanceRequestDTO {

    @NotNull
    @Positive
    double amount;
    @NotNull
    OperationType operationType;


    public UpdateBalanceRequestDTO() {
    }

    public UpdateBalanceRequestDTO(double amount, OperationType operationType) {
        this.amount = amount;
        this.operationType = operationType;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return this.operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public UpdateBalanceRequestDTO amount(double amount) {
        setAmount(amount);
        return this;
    }

    public UpdateBalanceRequestDTO operationType(OperationType operationType) {
        setOperationType(operationType);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UpdateBalanceRequestDTO)) {
            return false;
        }
        UpdateBalanceRequestDTO updateBalanceRequestDTO = (UpdateBalanceRequestDTO) o;
        return amount == updateBalanceRequestDTO.amount && Objects.equals(operationType, updateBalanceRequestDTO.operationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, operationType);
    }

    @Override
    public String toString() {
        return "{" +
            " amount='" + getAmount() + "'" +
            ", operationType='" + getOperationType() + "'" +
            "}";
    }
    
    
}
