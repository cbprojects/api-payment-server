package com.project.cafe.api.controller;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.model.dto.StandardResponseDTO;
import com.project.cafe.api.model.dto.SubscriptionDTO;
import com.project.cafe.api.service.ISubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

  private final ISubscriptionService subscriptionService;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<StandardResponseDTO> find() throws ModelException {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(subscriptionService.find()),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelException(e.getMessage());
    }
  }

  @GetMapping(
    value = "/{userEmail}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<StandardResponseDTO> findByUserEmail(
    @PathVariable("userEmail") String userEmail
  ) throws ModelException {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(subscriptionService.findByUserEmail(userEmail)),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelException(e.getMessage());
    }
  }

  @PostMapping(
    value = "",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<StandardResponseDTO> save(
    @RequestBody SubscriptionDTO request
  ) throws ModelException {
    try {
      return new ResponseEntity<>(
        new StandardResponseDTO(subscriptionService.save(request)),
        HttpStatus.OK
      );
    } catch (Exception e) {
      throw new ModelException(e.getMessage());
    }
  }
}
