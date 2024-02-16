package com.project.cafe.api.model.entity;

import com.project.cafe.api.helper.constant.ConstantsTableNames;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Document(collection = ConstantsTableNames.HISTORICAL)
public class HistoricalEntity extends BaseEntity {

  @DBRef(lazy = true)
  @Field("payment")
  private PaymentEntity payment;

  @Field("stripe_message")
  private String stripeMessage;
}
