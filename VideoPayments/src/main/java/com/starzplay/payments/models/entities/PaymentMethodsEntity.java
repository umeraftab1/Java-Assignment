package com.starzplay.payments.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PAYMENT_METHODS")
public class PaymentMethodsEntity implements Serializable {

    @Id
    @GeneratedValue
    private int paymentMethodId;
    private String name;
    private String displayName;
    private String paymentType;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "paymentMethodsEntity", fetch = FetchType.EAGER)
    private List<PaymentPlansEntity> paymentPlansEntities;

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<PaymentPlansEntity> getPaymentPlansEntities() {
        return paymentPlansEntities;
    }

    public void setPaymentPlansEntities(List<PaymentPlansEntity> paymentPlansEntities) {
        this.paymentPlansEntities = paymentPlansEntities;
    }
}
