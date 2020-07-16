package com.starzplay.payments.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PAYMENT_PLANS")
public class PaymentPlansEntity implements Serializable {

    @Id
    @GeneratedValue
    private int paymentPlanId;
    private double netAmount;
    private double taxAmount;
    private double grossAmount;
    private String currency;
    private String duration;
    @ManyToOne
    @JoinColumn(name = "paymentMethodId")
    private PaymentMethodsEntity paymentMethodsEntity;

    public int getPaymentPlanId() {
        return paymentPlanId;
    }

    public void setPaymentPlanId(int paymentPlanId) {
        this.paymentPlanId = paymentPlanId;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public PaymentMethodsEntity getPaymentMethodsEntity() {
        return paymentMethodsEntity;
    }

    public void setPaymentMethodsEntity(PaymentMethodsEntity paymentMethodsEntity) {
        this.paymentMethodsEntity = paymentMethodsEntity;
    }
}
