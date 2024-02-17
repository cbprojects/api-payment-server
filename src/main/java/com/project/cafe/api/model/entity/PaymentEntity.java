package com.project.cafe.api.model.entity;

import com.project.cafe.api.helper.constant.ConstantsTableNames;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Document(collection = ConstantsTableNames.PAYMENTS)
public class PaymentEntity extends BaseEntity {

  @Field("currency")
  private String currency;

  @Field("value")
  private BigDecimal value;

  @Field("status")
  private int status;

  @DBRef(lazy = true)
  @Field("subscription")
  private SubscriptionEntity subscription;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Field("payment_date")
  private LocalDateTime paymentDate;
}
