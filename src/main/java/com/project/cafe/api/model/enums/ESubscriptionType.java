package com.project.cafe.api.model.enums;

import java.math.BigDecimal;
import lombok.Getter;

@Getter
public enum ESubscriptionType {
  MENSUAL("Mensual", BigDecimal.valueOf(9.99)),
  ANUAL("Anual", BigDecimal.valueOf(90));

  private final String nombre;
  private final BigDecimal valor;

  private ESubscriptionType(String nombre, BigDecimal valor) {
    this.nombre = nombre;
    this.valor = valor;
  }

  public ESubscriptionType getByOrdinal(int ordinal) {
    ESubscriptionType result = null;
    for (ESubscriptionType enumItem : ESubscriptionType.values()) {
      if (enumItem.ordinal() == ordinal) {
        result = enumItem;
        break;
      }
    }

    return result;
  }
}
