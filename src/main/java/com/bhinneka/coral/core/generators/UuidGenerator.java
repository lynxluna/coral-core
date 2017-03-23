package com.bhinneka.coral.core.generators;

import com.bhinneka.coral.core.IdGenerator;
import com.bhinneka.coral.core.handlers.AsyncHandler;

import java.util.UUID;

/**
 * Built-in generator for {@link UUID UUID} type.
 */
public class UuidGenerator implements IdGenerator<UUID> {
  @Override
  public void nextValue(AsyncHandler<UUID> handler) {
    handler.onSuccess(UUID.randomUUID());
  }
}
