package com.bhinneka.coral.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.bhinneka.coral.core.generators.UuidGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class UuidGeneratorTest {

  @Mock
  private Consumer<UUID> mockConsumer;

  @Captor
  private ArgumentCaptor<UUID> uuidCaptor;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testUUIDGenerator() {
    final IdGenerator<UUID> generator = new UuidGenerator();
    generator.nextValue().thenAccept(mockConsumer).join();

    verify(mockConsumer, times(1)).accept(uuidCaptor.capture());
    assertThat(uuidCaptor.getValue()).isInstanceOf(UUID.class);
  }
}
