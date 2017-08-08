package x.y.z;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by PS89152 on 03-08-2017.
 */
public class StringsIsUniqueTest {

   @Test
   public void notUnique() {
      Assert.assertFalse(Strings.isUnique("abcda"));
   }

   @Test
   public void unique() {
      Assert.assertFalse(Strings.isUnique("abcd"));
   }

   @Test
   public void emptyString() {
      Assert.assertTrue(Strings.isUnique(""));
   }

   @Test(expectedExceptions = AssertionError.class)
   public void nullString() {
      Assert.assertTrue(Strings.isUnique(null));
   }
}
