package com.starzplay.payments.models.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentMethodDTO {

    private String name;
    private String displayName;
    private String paymentType;
    private List<PaymentPlansDTO> paymentPlans;

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

    public List<PaymentPlansDTO> getPaymentPlans() {
        return paymentPlans;
    }

    public void setPaymentPlans(List<PaymentPlansDTO> paymentPlans) {
        this.paymentPlans = paymentPlans;
    }
}
