package x.y.z;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringBracesTest {

   @Test
   public void testPositive(){
      Assert.assertTrue(Strings.areBracesInValidOrder("{a(  b{ c()})}"));
      Assert.assertTrue(Strings.areBracesInValidOrder("(( ((a bc)) ))"));
      Assert.assertTrue(Strings.areBracesInValidOrder("({ ({( {(abc)} )}   )}) {}{{ x}}(({ y} ))"));
      Assert.assertTrue(Strings.areBracesInValidOrder("()"));
      Assert.assertTrue(Strings.areBracesInValidOrder(""));
   }
   @Test
   public void testNegative(){
      Assert.assertFalse(Strings.areBracesInValidOrder("{"));
      Assert.assertFalse(Strings.areBracesInValidOrder("}"));
      Assert.assertFalse(Strings.areBracesInValidOrder("((}}"));
      Assert.assertFalse(Strings.areBracesInValidOrder("(()"));
      Assert.assertFalse(Strings.areBracesInValidOrder("{{}"));
      Assert.assertFalse(Strings.areBracesInValidOrder("{a(  b{ c())}"));
      Assert.assertFalse(Strings.areBracesInValidOrder("(( ((a bc)))"));
      Assert.assertFalse(Strings.areBracesInValidOrder("({ ({( {(abc)} )}   )} {}{{ x}}(({ y} ))"));
      Assert.assertFalse(Strings.areBracesInValidOrder("({)}"));
   }
}
