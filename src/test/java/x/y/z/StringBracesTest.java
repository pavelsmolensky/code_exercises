package x.y.z;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringBracesTest {

  @Test
  void testPositive() {
    assertTrue(Strings.areBracesInValidOrder("{a(  b{ c()})}"));
    assertTrue(Strings.areBracesInValidOrder("(( ((a bc)) ))"));
    assertTrue(Strings.areBracesInValidOrder("({ ({( {(abc)} )}   )}) {}{{ x}}(({ y} ))"));
    assertTrue(Strings.areBracesInValidOrder("()"));
    assertTrue(Strings.areBracesInValidOrder(""));
  }

  @Test
  void testNegative() {
    assertFalse(Strings.areBracesInValidOrder("{"));
    assertFalse(Strings.areBracesInValidOrder("}"));
    assertFalse(Strings.areBracesInValidOrder("((}}"));
    assertFalse(Strings.areBracesInValidOrder("(()"));
    assertFalse(Strings.areBracesInValidOrder("{{}"));
    assertFalse(Strings.areBracesInValidOrder("{a(  b{ c())}"));
    assertFalse(Strings.areBracesInValidOrder("(( ((a bc)))"));
    assertFalse(Strings.areBracesInValidOrder("({ ({( {(abc)} )}   )} {}{{ x}}(({ y} ))"));
    assertFalse(Strings.areBracesInValidOrder("({)}"));
  }
}
