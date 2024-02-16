package com.project.cafe.api.model.mapper;

import com.project.cafe.api.model.dto.SubscriptionDTO;
import com.project.cafe.api.model.entity.SubscriptionEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
  SubscriptionDTO toDTO(SubscriptionEntity entity);

  SubscriptionEntity toEntity(SubscriptionDTO dto);

  List<SubscriptionDTO> map(List<SubscriptionEntity> entities);
}
