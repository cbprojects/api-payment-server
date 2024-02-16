package com.project.cafe.api.service;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.model.dto.PaymentDTO;
import java.util.List;

public interface IPaymentService {
  List<PaymentDTO> find() throws ModelException;

  PaymentDTO findById(String id) throws ModelException;

  List<PaymentDTO> findBySubscriptionId(String id) throws ModelException;

  List<PaymentDTO> findBySubscriptionUserId(String userId)
    throws ModelException;

  List<PaymentDTO> findBySubscriptionUserName(String userName)
    throws ModelException;

  List<PaymentDTO> findBySubscriptionUserEmail(String userEmail)
    throws ModelException;

  PaymentDTO save(PaymentDTO dto) throws ModelException;
}
