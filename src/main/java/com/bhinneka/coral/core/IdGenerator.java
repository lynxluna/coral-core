package com.bhinneka.coral.core;

import java.util.concurrent.CompletableFuture;

/**
 * The generator of the entity ID.
 *
 * @param <T> the type of the entity Id.
 *           This should be {@link java.util.UUID UUID}, {@link String}, or {@link Integer}
 */
public interface IdGenerator<T> {

  /**
   * Generate next value for the Entity ID.
   *
   * @return future containing next value.
   */
  CompletableFuture <T> nextValue();
}
