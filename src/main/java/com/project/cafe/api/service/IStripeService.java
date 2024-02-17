package com.project.cafe.api.service;

import com.project.cafe.api.model.dto.PaymentDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

public interface IStripeService {
  Charge charge(PaymentDTO paymentDTO) throws StripeException;
}
