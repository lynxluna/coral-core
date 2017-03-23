package com.bhinneka.coral.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.bhinneka.coral.core.generators.UuidGenerator;
import com.bhinneka.coral.core.handlers.AsyncHandler;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.UUID;

public class UuidGeneratorTest {

  @Mock
  private AsyncHandler<UUID> mockHandler;

  @Captor
  private ArgumentCaptor<UUID> uuidCaptor;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testUUIDGenerator() {
    final IdGenerator<UUID> generator = new UuidGenerator();
    generator.nextValue(mockHandler);

    verify(mockHandler, never()).onError(Mockito.<Exception>any());
    verify(mockHandler, times(1)).onSuccess(uuidCaptor.capture());

    assertThat(uuidCaptor.getValue()).isInstanceOf(UUID.class);
  }
}
