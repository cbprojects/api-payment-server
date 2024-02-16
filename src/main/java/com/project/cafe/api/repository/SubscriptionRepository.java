package com.project.cafe.api.repository;

import com.project.cafe.api.model.entity.SubscriptionEntity;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository
  extends MongoRepository<SubscriptionEntity, String> {
  Optional<SubscriptionEntity> findById(String id);

  Optional<SubscriptionEntity> findByUserId(String userId);

  Optional<SubscriptionEntity> findByUserName(String userName);

  Optional<SubscriptionEntity> findByUserEmail(String userEmail);
}
