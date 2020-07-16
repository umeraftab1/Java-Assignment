package com.starzplay.payments.services;

import java.util.List;
import com.starzplay.payments.models.dto.PaymentMethodDTO;

public interface PaymentServiceInterface {

  public abstract List<PaymentMethodDTO> getAllPaymentMethods(Integer id, String name);
  
  public abstract String addPaymentMethod(PaymentMethodDTO paymentMethod);
  
  public abstract String updatePaymentMethod(Integer id, PaymentMethodDTO paymentMethod);
}
