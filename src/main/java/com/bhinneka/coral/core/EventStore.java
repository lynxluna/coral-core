package com.bhinneka.coral.core;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Implement this store to persist and load {@link EventInfo EventInfo}.
 *
 * @param <I> entity id.
 * @param <S> the state of the entity.
 */
public interface EventStore<I, S> {

  /**
   * Loads all events for and entity of specific id.
   *
   * @param id the entity id to query.
   * @return future containing last state.
   */
  CompletableFuture<Iterable<EventInfo<I, S>>> load(I id);

  /**
   * Loads all events of an entity to specific version.
   *
   * @param id the entity id.
   * @param version the last version queried.
   * @return future containing state of specific version
   */
  CompletableFuture<Iterable<EventInfo<I, S>>> load (I id, int version);

  /**
   * Commits an event to the event store.
   *
   * @param eventInfo event information to be persisted.
   * @return future with identity of committed event.
   */
  CompletableFuture<I> commit(EventInfo<I, S> eventInfo);
}
