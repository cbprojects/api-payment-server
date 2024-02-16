package com.project.cafe.api.repository;

import com.project.cafe.api.model.entity.PaymentEntity;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PaymentRepository
  extends MongoRepository<PaymentEntity, String> {
  Optional<PaymentEntity> findById(String id);

  @Query("{ 'subscription._id' : ?0 }")
  List<PaymentEntity> findBySubscriptionId(ObjectId subscriptionId);

  @Query("{ 'subscription.user_id' : ?0 }")
  List<PaymentEntity> findBySubscriptionUserId(String userId);

  @Query("{ 'subscription.user_name' : ?0 }")
  List<PaymentEntity> findBySubscriptionUserName(String userName);

  @Query("{ 'subscription.user_email' : ?0 }")
  List<PaymentEntity> findBySubscriptionUserEmail(String userEmail);
}
