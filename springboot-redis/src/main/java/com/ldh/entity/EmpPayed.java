package com.ldh.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmpPayed
 */
@Entity
@Table(name = "EMP_PAYED")
public class EmpPayed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private BigDecimal payedId;
    // @OneToOne
    // @JoinColumn(name = "id")
    private BigDecimal id;

    private Integer years;

    private Long amount;

    public BigDecimal getPayedId() {
        return payedId;
    }

    public void setPayedId(BigDecimal payedId) {
        this.payedId = payedId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", payedId=").append(payedId);
        sb.append(", id=").append(id);
        sb.append(", years=").append(years);
        sb.append(", amount=").append(amount);
        sb.append("]");
        return sb.toString();
    }
}