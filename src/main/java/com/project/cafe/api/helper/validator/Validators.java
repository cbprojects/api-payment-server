package com.project.cafe.api.helper.validator;

import com.project.cafe.api.helper.constant.ConstantsFields;
import com.project.cafe.api.helper.constant.ConstantsMessages;
import com.project.cafe.api.helper.constant.ConstantsValidators;
import com.project.cafe.api.model.dto.PaymentDTO;
import com.project.cafe.api.model.dto.SubscriptionDTO;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Validators {

  public static boolean esCorreoValido(String email) {
    Matcher mather = ConstantsValidators.EMAIL_PATTERN.matcher(
      email.toLowerCase()
    );
    return mather.find();
  }

  public static boolean tieneCantidadCharPermitida(
    String cadenaValidar,
    int cantidadChar
  ) {
    boolean result = false;
    if (!StringUtils.isBlank(cadenaValidar)) {
      result = cadenaValidar.length() <= cantidadChar;
    }
    return result;
  }

  public static String isValidPayment(PaymentDTO dto) {
    String error = null;
    if (dto == null) {
      error = ConstantsMessages.BAD_REQUEST;
    } else {
      if (dto.getValue().compareTo(BigDecimal.ZERO) < 0) {
        error = ConstantsFields.VALOR + ConstantsMessages.BAD_VALUE;
      }
    }

    return error;
  }

  public static String isValidSubscription(SubscriptionDTO dto) {
    String error = null;
    if (dto == null) {
      error = ConstantsMessages.BAD_REQUEST;
    } else {
      if (dto.getValue().compareTo(BigDecimal.ZERO) < 0) {
        error = ConstantsFields.VALOR + ConstantsMessages.BAD_VALUE;
      }
    }

    return error;
  }
}
