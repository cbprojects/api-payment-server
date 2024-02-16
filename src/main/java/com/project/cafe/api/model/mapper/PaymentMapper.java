package com.project.cafe.api.model.mapper;

import com.project.cafe.api.model.dto.PaymentDTO;
import com.project.cafe.api.model.entity.PaymentEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
  PaymentDTO toDTO(PaymentEntity entity);

  PaymentEntity toEntity(PaymentDTO dto);

  List<PaymentDTO> map(List<PaymentEntity> entities);
}
