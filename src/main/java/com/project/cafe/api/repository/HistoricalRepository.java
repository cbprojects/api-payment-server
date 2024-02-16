package com.project.cafe.api.repository;

import com.project.cafe.api.model.entity.HistoricalEntity;
import com.project.cafe.api.model.entity.SubscriptionEntity;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface HistoricalRepository
  extends MongoRepository<HistoricalEntity, String> {
  Optional<HistoricalEntity> findById(String id);

  @Query("{ 'payment._id' : ?0 }")
  List<SubscriptionEntity> findByPaymentId(ObjectId paymentId);

  @Query("{ 'payment.subscription._id' : ?0 }")
  List<SubscriptionEntity> findBySubscriptionId(ObjectId subscriptionId);
}
