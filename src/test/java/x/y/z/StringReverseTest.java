package x.y.z;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringReverseTest {
  @Test
  public void reverseOddLength(){
    String str = "abcdefg";
    String expected = "gfedcba";
    Assert.assertEquals(Strings.reverse(str), expected);
    Assert.assertEquals(Strings.reverseRecur(str), expected);
  }

  @Test
  public void reverseEvenLength(){
    String str = "aaabbb";
    String expected = "bbbaaa";
    Assert.assertEquals(Strings.reverse(str), expected);
    Assert.assertEquals(Strings.reverseRecur(str), expected);
  }

  @Test
  public void reverse2CharString(){
    String str = "12";
    String expected = "21";
    Assert.assertEquals(Strings.reverse(str), expected);
    Assert.assertEquals(Strings.reverseRecur(str), expected);
  }

  @Test
  public void reverse1CharString(){
    String str = "a";
    Assert.assertEquals(Strings.reverse(str), str);
    Assert.assertEquals(Strings.reverseRecur(str), str);
  }

  @Test
  public void reverseEmptyString(){
    String str = "";
    Assert.assertEquals(Strings.reverse(str), str);
    Assert.assertEquals(Strings.reverseRecur(str), str);
  }
}
