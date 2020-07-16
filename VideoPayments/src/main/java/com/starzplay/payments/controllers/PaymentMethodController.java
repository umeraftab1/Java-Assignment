package com.starzplay.payments.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.starzplay.payments.models.dto.PaymentMethodDTO;
import com.starzplay.payments.services.PaymentMethodService;
import com.sun.istack.NotNull;

/**
 * @author Umer.Aftab
 *
 */
@RestController
@RequestMapping(path = "configuration")
public class PaymentMethodController {

  @Autowired
  private PaymentMethodService service;

  /**
   * get all payment records
   * 
   * @param id
   * @param name
   * @return
   */
  @GetMapping(value = "payment-methods", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PaymentMethodDTO> getAllPaymentMethods(@RequestParam(required = false) Integer id,
      @RequestParam(required = false) String name) {
    return service.getAllPaymentMethods(id, name);
  }

  /**
   * add payment method
   * 
   * @param requestPaymentObject
   * @return
   */
  @PostMapping(value = "payment-methods", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String addPaymentMethod(
      @RequestBody @NotNull PaymentMethodDTO requestPaymentObject) {
    return service.addPaymentMethod(requestPaymentObject);
  }
  
  /**
   * update payment method
   * 
   * @param requestPaymentObject
   * @return
   */
  @PutMapping(value = "payment-methods", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public String updatePaymentMethod(@RequestParam(required = true) Integer id,
      @RequestBody @NotNull PaymentMethodDTO requestPaymentObject) {
    return service.updatePaymentMethod(id, requestPaymentObject);
  }
}
