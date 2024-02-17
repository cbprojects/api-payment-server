package com.project.cafe.api.service.impl;

import com.project.cafe.api.model.dto.PaymentDTO;
import com.project.cafe.api.service.IStripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.TokenCreateParams;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService implements IStripeService {

  @Value("${API_STRIPE_PUBLIC_KEY}")
  private String publicKey;

  @Value("${API_STRIPE_PRIVATE_KEY}")
  private String secretKey;

  @PostConstruct
  public void init() {
    Stripe.apiKey = secretKey;
  }

  @Override
  public Charge charge(PaymentDTO paymentDTO) throws StripeException {
    String token = "tok_visa"; //this.getStripeToken();

    Stripe.apiKey = secretKey;
    ChargeCreateParams params = ChargeCreateParams
      .builder()
      .setAmount(paymentDTO.getValue().longValue())
      .setCurrency(paymentDTO.getCurrency())
      .setSource(token)
      .build();

    return Charge.create(params);
  }

  private String getStripeToken() throws StripeException {
    Stripe.apiKey = secretKey;
    TokenCreateParams params = TokenCreateParams
      .builder()
      .setCard(
        TokenCreateParams.Card
          .builder()
          .setNumber("4242424242424242")
          .setExpMonth("12")
          .setExpYear("2034")
          .setCvc("314")
          .build()
      )
      .build();
    Token token = Token.create(params);

    return token.getId();
  }
}
