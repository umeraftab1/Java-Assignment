package com.starzplay.payments.models.dto;

import java.util.List;

public class RequestResponseDTO {

  private List<PaymentMethodDTO> paymentMethods;

  public List<PaymentMethodDTO> getPaymentMethods() {
    return paymentMethods;
  }

  public void setPaymentMethods(List<PaymentMethodDTO> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }
}
