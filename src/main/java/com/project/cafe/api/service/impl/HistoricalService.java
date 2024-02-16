package com.project.cafe.api.service.impl;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.model.entity.HistoricalEntity;
import com.project.cafe.api.model.entity.PaymentEntity;
import com.project.cafe.api.repository.HistoricalRepository;
import com.project.cafe.api.service.IHistoricalService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoricalService implements IHistoricalService {

  private final HistoricalRepository repository;

  @Override
  public HistoricalEntity save(
    PaymentEntity paymentEntity,
    String stripeMessage
  ) throws ModelException {
    try {
      // Mapper to entity
      HistoricalEntity entity = new HistoricalEntity();
      entity.setPayment(paymentEntity);
      entity.setStripeMessage(stripeMessage);
      entity.setActive(true);

      // Set audit values
      this.setAuditValues(entity);

      // Save entity
      return this.repository.save(entity);
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  private void setAuditValues(HistoricalEntity entity) {
    LocalDateTime now = LocalDateTime.now();
    entity.setCreateDate(now);
    entity.setUpdateDate(now);
  }
}
