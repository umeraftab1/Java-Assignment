package com.starzplay.payments.repository;

import com.starzplay.payments.models.entities.PaymentMethodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodsEntity, Integer> {

    List<PaymentMethodsEntity> findAllByNameIgnoreCase(String name);
    List<PaymentMethodsEntity> findByPaymentPlansEntitiesPaymentPlanId(int id);
}
