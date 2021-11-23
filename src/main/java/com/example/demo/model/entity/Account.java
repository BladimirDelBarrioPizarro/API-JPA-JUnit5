package com.example.demo.model.entity;

import com.example.demo.model.exceptions.HandleExceptionDevit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    public String person;
    public BigDecimal balance;
    public Bank bank;

    public void setSumDevit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void setSubstractDevit(BigDecimal amount) {
        BigDecimal newDebit = this.balance.subtract(amount);
        if(newDebit.intValue() < 0){
            throw new HandleExceptionDevit("Insufficient Money");
        }
        this.balance = this.balance.subtract(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(person, account.person) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, balance);
    }
}
