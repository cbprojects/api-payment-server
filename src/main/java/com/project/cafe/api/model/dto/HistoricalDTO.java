package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoricalDTO extends BaseDTO {

  @Valid
  @NotNull
  private SubscriptionDTO subscription;

  @Valid
  @NotBlank
  private String stripeMessage;
}
