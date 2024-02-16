package com.project.cafe.api.service.impl;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.helper.validator.Validators;
import com.project.cafe.api.model.dto.PaymentDTO;
import com.project.cafe.api.model.entity.PaymentEntity;
import com.project.cafe.api.model.enums.EPaymentStatus;
import com.project.cafe.api.model.mapper.PaymentMapper;
import com.project.cafe.api.repository.PaymentRepository;
import com.project.cafe.api.service.IPaymentService;
import io.micrometer.core.instrument.util.StringUtils;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService {

  private final PaymentMapper mapper;
  private final PaymentRepository repository;
  private final HistoricalService historicalService;

  @Override
  public List<PaymentDTO> find() throws ModelException {
    try {
      List<PaymentDTO> result = new ArrayList<>();
      List<PaymentEntity> entities = repository.findAll();
      if (!entities.isEmpty()) {
        result = mapper.map(entities);
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public PaymentDTO findById(String id) throws ModelException {
    try {
      PaymentDTO result = null;
      Optional<PaymentEntity> optional = repository.findById(id);
      if (optional.isPresent()) {
        result = mapper.toDTO(optional.get());
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public List<PaymentDTO> findBySubscriptionId(String subscriptionId)
    throws ModelException {
    try {
      List<PaymentDTO> result = null;
      List<PaymentEntity> entities = repository.findBySubscriptionId(
        new ObjectId(subscriptionId)
      );
      if (entities != null && !entities.isEmpty()) {
        result = mapper.map(entities);
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public List<PaymentDTO> findBySubscriptionUserId(String userId)
    throws ModelException {
    try {
      List<PaymentDTO> result = null;
      List<PaymentEntity> entities = repository.findBySubscriptionUserId(
        userId
      );
      if (entities != null && !entities.isEmpty()) {
        result = mapper.map(entities);
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public List<PaymentDTO> findBySubscriptionUserName(String userName)
    throws ModelException {
    try {
      List<PaymentDTO> result = null;
      List<PaymentEntity> entities = repository.findBySubscriptionUserName(
        userName
      );
      if (entities != null && !entities.isEmpty()) {
        result = mapper.map(entities);
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public List<PaymentDTO> findBySubscriptionUserEmail(String userEmail)
    throws ModelException {
    try {
      List<PaymentDTO> result = null;
      List<PaymentEntity> entities = repository.findBySubscriptionUserEmail(
        userEmail
      );
      if (entities != null && !entities.isEmpty()) {
        result = mapper.map(entities);
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public PaymentDTO save(PaymentDTO dto) throws ModelException {
    // Request validation
    String error = Validators.isValidPayment(dto);
    if (StringUtils.isNotBlank(error)) {
      throw new ModelException(error);
    }

    try {
      // Mapper to entity
      PaymentEntity entity = mapper.toEntity(dto);

      // Set audit values
      this.setAuditValues(entity);

      // Call to API STRIPE
      String stripeMsg = "TODO: WebClient to Stripe";

      // TODO: Status depende de respuesta de Stripe
      // Save entity
      entity.setStatus(EPaymentStatus.PENDIENTE.ordinal());
      entity = this.repository.save(entity);

      // Save Historical
      this.historicalService.save(entity, stripeMsg);

      return mapper.toDTO(entity);
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  private void setAuditValues(PaymentEntity entity) {
    LocalDateTime now = LocalDateTime.now();
    entity.setCreateDate(now);
    entity.setUpdateDate(now);
  }
}
