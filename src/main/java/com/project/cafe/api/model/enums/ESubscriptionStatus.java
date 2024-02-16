package com.project.cafe.api.model.enums;

import lombok.Getter;

@Getter
public enum ESubscriptionStatus {
  ACTIVA("Activa"),
  PENDIENTE_PAGO("Pendiente de Pago"),
  SUSPENDIDA("Suspendida");

  private final String nombre;

  private ESubscriptionStatus(String nombre) {
    this.nombre = nombre;
  }

  public ESubscriptionStatus getByOrdinal(int ordinal) {
    ESubscriptionStatus result = null;
    for (ESubscriptionStatus enumItem : ESubscriptionStatus.values()) {
      if (enumItem.ordinal() == ordinal) {
        result = enumItem;
        break;
      }
    }

    return result;
  }
}
