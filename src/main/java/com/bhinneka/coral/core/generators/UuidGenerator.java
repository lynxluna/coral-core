package com.bhinneka.coral.core.generators;

import com.bhinneka.coral.core.IdGenerator;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Built-in generator for {@link UUID UUID} type.
 */
public class UuidGenerator implements IdGenerator<UUID> {
  @Override
  public CompletableFuture<UUID> nextValue() {
    return CompletableFuture.supplyAsync(UUID::randomUUID);
  }
}
