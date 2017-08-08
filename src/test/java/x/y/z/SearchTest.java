package x.y.z;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {

  @Test
  public void findEachElementOfArray() {
    Integer[] array = new Integer[]{3, 6, 7, 9, 34, 59, 99};
    for (int i = 0; i < array.length; i++) {
      Assert.assertEquals(Search.binaryArraySearch(array, array[i]), i);
      Assert.assertEquals(Search.binaryArraySearchRec(array, array[i]), i);
    }
  }
  @Test
  public void findElementNotInArray(){
    Integer[] array = new Integer[]{3, 6, 7, 9, 34, 59, 99};
    Assert.assertEquals(Search.binaryArraySearch(array, 42), -1);
    Assert.assertEquals(Search.binaryArraySearch(array, 300), -1);
    Assert.assertEquals(Search.binaryArraySearch(array, 1), -1);

    Assert.assertEquals(Search.binaryArraySearchRec(array, 42), -1);
    Assert.assertEquals(Search.binaryArraySearchRec(array, 300), -1);
    Assert.assertEquals(Search.binaryArraySearchRec(array, 1), -1);
  }
}
