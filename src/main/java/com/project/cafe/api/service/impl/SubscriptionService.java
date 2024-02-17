package com.project.cafe.api.service.impl;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.helper.validator.Validators;
import com.project.cafe.api.model.dto.SubscriptionDTO;
import com.project.cafe.api.model.entity.SubscriptionEntity;
import com.project.cafe.api.model.enums.ESubscriptionStatus;
import com.project.cafe.api.model.mapper.SubscriptionMapper;
import com.project.cafe.api.repository.SubscriptionRepository;
import com.project.cafe.api.service.ISubscriptionService;
import io.micrometer.core.instrument.util.StringUtils;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService implements ISubscriptionService {

  private final SubscriptionMapper mapper;
  private final SubscriptionRepository repository;

  @Override
  public List<SubscriptionDTO> find() throws ModelException {
    try {
      List<SubscriptionDTO> result = new ArrayList<>();
      List<SubscriptionEntity> entities = repository.findAll();
      if (!entities.isEmpty()) {
        result = mapper.map(entities);
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public SubscriptionDTO findById(String id) throws ModelException {
    try {
      SubscriptionDTO result = null;
      Optional<SubscriptionEntity> optional = repository.findById(id);
      if (optional.isPresent()) {
        result = mapper.toDTO(optional.get());
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public SubscriptionDTO findByUserId(String userId) throws ModelException {
    try {
      SubscriptionDTO result = null;
      Optional<SubscriptionEntity> optional = repository.findByUserId(userId);
      if (optional.isPresent()) {
        result = mapper.toDTO(optional.get());
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public SubscriptionDTO findByUserName(String userName) throws ModelException {
    try {
      SubscriptionDTO result = null;
      Optional<SubscriptionEntity> optional = repository.findByUserName(
        userName
      );
      if (optional.isPresent()) {
        result = mapper.toDTO(optional.get());
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public SubscriptionDTO findByUserEmail(String userEmail)
    throws ModelException {
    try {
      SubscriptionDTO result = null;
      Optional<SubscriptionEntity> optional = repository.findByUserEmail(
        userEmail
      );
      if (optional.isPresent()) {
        result = mapper.toDTO(optional.get());
      }

      return result;
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  @Override
  public SubscriptionDTO save(SubscriptionDTO dto) throws ModelException {
    // Request validation
    String error = Validators.isValidSubscription(dto);
    if (StringUtils.isNotBlank(error)) {
      throw new ModelException(error);
    }

    try {
      // Mapper to entity
      SubscriptionEntity entity = mapper.toEntity(dto);

      // Set audit values
      this.setAuditValues(entity);

      // Save entity
      entity.setStatus(ESubscriptionStatus.ACTIVA.ordinal());
      entity = this.repository.save(entity);

      return mapper.toDTO(entity);
    } catch (Exception excepcion) {
      throw new ModelException(excepcion.getMessage());
    }
  }

  private void setAuditValues(SubscriptionEntity entity) {
    LocalDateTime now = LocalDateTime.now();
    entity.setCreateDate(now);
    entity.setUpdateDate(now);
  }
}
