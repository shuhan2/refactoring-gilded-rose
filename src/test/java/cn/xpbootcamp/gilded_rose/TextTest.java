package cn.xpbootcamp.gilded_rose;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTest {

  @Test
  void should_return_expected_value() throws IOException {
    String actualValue = TextTestFixture.getBaseValue();
    String expectedValue = Files.asCharSource(new File("src/test/java/cn/xpbootcamp/gilded_rose/baseValue.txt"), UTF_8).read();
    assertEquals(expectedValue, actualValue);
  }
}
