package x.y.z;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringsIsUniqueTest {

  @Test
  void notUnique() {
    assertFalse(Strings.isUnique("abcda"));
  }

  @Test
  void unique() {
    assertFalse(Strings.isUnique("abcd"));
  }

  @Test
  void emptyString() {
    assertTrue(Strings.isUnique(""));
  }

  @Test
//TODO
  void nullString() {
    assertThrows(AssertionError.class, () -> Strings.isUnique(null));
  }
}
