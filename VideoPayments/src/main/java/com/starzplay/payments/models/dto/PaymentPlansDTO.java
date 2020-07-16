package com.starzplay.payments.models.dto;

import org.springframework.stereotype.Component;

@Component
public class PaymentPlansDTO {

  private int id;
  private double netAmount;
  private double taxAmount;
  private double grossAmount;
  private String currency;
  private String duration;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
}
