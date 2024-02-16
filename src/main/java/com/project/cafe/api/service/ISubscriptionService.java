package com.project.cafe.api.service;

import com.project.cafe.api.exception.impl.ModelException;
import com.project.cafe.api.model.dto.SubscriptionDTO;
import java.util.List;

public interface ISubscriptionService {
  List<SubscriptionDTO> find() throws ModelException;

  SubscriptionDTO findById(String id) throws ModelException;

  SubscriptionDTO findByUserId(String userId) throws ModelException;

  SubscriptionDTO findByUserName(String userName) throws ModelException;

  SubscriptionDTO findByUserEmail(String userEmail) throws ModelException;

  SubscriptionDTO save(SubscriptionDTO dto) throws ModelException;
}
