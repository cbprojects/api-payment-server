package com.project.cafe.api.service;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.model.entity.HistoricalEntity;
import com.project.cafe.api.model.entity.PaymentEntity;

public interface IHistoricalService {
  HistoricalEntity save(PaymentEntity entity, String stripeMessage)
    throws ModelException;
}
