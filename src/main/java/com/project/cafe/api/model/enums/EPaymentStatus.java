package com.project.cafe.api.model.enums;

import lombok.Getter;

@Getter
public enum EPaymentStatus {
  PENDIENTE("Pendiente"),
  PAGADO("Pagado"),
  RECHAZADO("Rechazado");

  private final String nombre;

  private EPaymentStatus(String nombre) {
    this.nombre = nombre;
  }

  public EPaymentStatus getByOrdinal(int ordinal) {
    EPaymentStatus result = null;
    for (EPaymentStatus enumItem : EPaymentStatus.values()) {
      if (enumItem.ordinal() == ordinal) {
        result = enumItem;
        break;
      }
    }

    return result;
  }
}
