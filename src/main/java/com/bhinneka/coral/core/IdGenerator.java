package com.bhinneka.coral.core;

import com.bhinneka.coral.core.handlers.AsyncHandler;

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
   * @return new value for entity ID.
   */
  void nextValue(AsyncHandler<T> handler);
}
