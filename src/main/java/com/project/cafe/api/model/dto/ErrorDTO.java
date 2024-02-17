package com.project.cafe.api.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {

  @JsonProperty(value = "class")
  private String clazz;

  private String method;
  private String line;
  private String message;
  private String details;
}
