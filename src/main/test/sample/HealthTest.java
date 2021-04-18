package sample;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HealthTest {

  @Test
  @DisplayName("Health.main")
  void testMain(){
    Health.main(new String[]{"arg1", "arg2", "arg3"});
  }
}