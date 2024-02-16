package com.project.cafe.api.model.entity;

import com.project.cafe.api.helper.constant.ConstantsTableNames;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@CompoundIndex(
  name = "email_user_subscription",
  def = "{'user_id' : 1, 'user_name' : 1, 'user_email': 1}",
  unique = true
)
@Document(collection = ConstantsTableNames.SUBSCRIPTIONS)
public class SubscriptionEntity extends BaseEntity {

  @Field("currency")
  private String currency;

  @Field("value")
  private BigDecimal value;

  @Field("type")
  private int type;

  @Field("user_id")
  private String userId;

  @Field("user_name")
  private String userName;

  @Field("user_email")
  private String userEmail;

  @Field("status")
  private int status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Field("expiration_date")
  private LocalDateTime expirationDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @Field("register_date")
  private LocalDateTime registerDate;
}
