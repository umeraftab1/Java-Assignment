package com.starzplay.payments.services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starzplay.payments.models.dto.PaymentMethodDTO;
import com.starzplay.payments.models.dto.PaymentPlansDTO;
import com.starzplay.payments.models.entities.PaymentMethodsEntity;
import com.starzplay.payments.models.entities.PaymentPlansEntity;
import com.starzplay.payments.repository.PaymentMethodRepository;

@Service
public class PaymentMethodService implements PaymentServiceInterface {

  @Autowired
  private PaymentMethodRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  final String PAYMENT_ADDED = "Payment added successfully";
  final String PAYMENT_UPDATED = "Payment updated successfully";

  @Override
  public List<PaymentMethodDTO> getAllPaymentMethods(Integer id, String name) {
    List<PaymentMethodsEntity> entity;

    if (name != null && id == null) {
      entity = repository.findAllByNameIgnoreCase(name);
    } else if (name == null && id != null) {
      entity = repository.findByPaymentPlansEntitiesPaymentPlanId(id);
    } else {
      entity = repository.findAll();
    }

    return entity.stream().map(e -> mapEntityToDTO(e, id)).collect(Collectors.toList());
  }

  @Override
  public String addPaymentMethod(PaymentMethodDTO paymentMethod) {
    repository.save(mapDTOToEntity(paymentMethod));
    return PAYMENT_ADDED;
  }

  @Override
  public String updatePaymentMethod(Integer id, PaymentMethodDTO paymentMethod) {
    PaymentMethodsEntity entity = repository.findByPaymentPlansEntitiesPaymentPlanId(id).get(0);
    
    // filter payment plan based on id
    entity.setPaymentPlansEntities(entity.getPaymentPlansEntities()
        .stream()
        .filter(e -> e.getPaymentPlanId() == id)
        .collect(Collectors.toList()));

    adaptPaymentMethodToDomain(entity, paymentMethod);
    
    repository.save(entity);
    return PAYMENT_UPDATED;
  }
  
  
  // Below are utility method. Can be moved to a utility class

  private PaymentMethodDTO mapEntityToDTO(PaymentMethodsEntity entity, Integer id) {
    PaymentMethodDTO dto = modelMapper.map(entity, PaymentMethodDTO.class);
    dto.setPaymentPlans(entity.getPaymentPlansEntities()
                              .stream()
                              .filter(e -> id == null || e.getPaymentPlanId() == id)
                              .map(e -> modelMapper.map(e, PaymentPlansDTO.class))
                              .collect(Collectors.toList()));
    return dto;
  }

  private PaymentMethodsEntity mapDTOToEntity(PaymentMethodDTO dto) {
    PaymentMethodsEntity pmEntity = modelMapper.map(dto, PaymentMethodsEntity.class);
    pmEntity.setPaymentPlansEntities(dto.getPaymentPlans()
            .stream()
            .map((e) -> {
              PaymentPlansEntity planEntity = modelMapper.map(e, PaymentPlansEntity.class);
              planEntity.setPaymentMethodsEntity(pmEntity);
              return planEntity;
            })
            .collect(Collectors.toList()));
    return pmEntity;
  }
  
  private void adaptPaymentMethodToDomain(PaymentMethodsEntity entity,
      PaymentMethodDTO paymentMethod) {
    PaymentPlansDTO paymentPlanDTO = paymentMethod.getPaymentPlans().get(0);
    PaymentPlansEntity paymentPlanEntity = entity.getPaymentPlansEntities().get(0);

    paymentPlanEntity.setNetAmount(paymentPlanDTO.getNetAmount());
    paymentPlanEntity.setTaxAmount(paymentPlanDTO.getTaxAmount());
    paymentPlanEntity.setGrossAmount(paymentPlanDTO.getGrossAmount());
    paymentPlanEntity.setCurrency(paymentPlanDTO.getCurrency());
    paymentPlanEntity.setDuration(paymentPlanDTO.getDuration());

    entity.setDisplayName(paymentMethod.getDisplayName());
    entity.setName(paymentMethod.getName());
    entity.setPaymentType(paymentMethod.getPaymentType());

  }

}
