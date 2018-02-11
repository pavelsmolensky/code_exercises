package x.y.z;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringReverseTest {
  @Test
  void reverseOddLength() {
    String str = "abcdefg";
    String expected = "gfedcba";
    assertEquals(Strings.reverse(str), expected);
    assertEquals(Strings.reverseRecur(str), expected);
  }

  @Test
  void reverseEvenLength() {
    String str = "aaabbb";
    String expected = "bbbaaa";
    assertEquals(Strings.reverse(str), expected);
    assertEquals(Strings.reverseRecur(str), expected);
  }

  @Test
  void reverse2CharString() {
    String str = "12";
    String expected = "21";
    assertEquals(Strings.reverse(str), expected);
    assertEquals(Strings.reverseRecur(str), expected);
  }

  @Test
  void reverse1CharString() {
    String str = "a";
    assertEquals(Strings.reverse(str), str);
    assertEquals(Strings.reverseRecur(str), str);
  }

  @Test
  void reverseEmptyString() {
    String str = "";
    assertEquals(Strings.reverse(str), str);
    assertEquals(Strings.reverseRecur(str), str);
  }
}
