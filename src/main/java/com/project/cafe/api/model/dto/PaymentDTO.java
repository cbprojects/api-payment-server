package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDTO extends BaseDTO {

  @Valid
  @NotBlank
  private String currency;

  @Valid
  @NotBlank
  private BigDecimal value;

  private int status;

  @Valid
  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime paymentDate;

  @Valid
  @NotNull
  private SubscriptionDTO subscription;
}
