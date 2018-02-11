package x.y.z;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

  @Test
  void findEachElementOfArray() {
    Integer[] array = new Integer[]{3, 6, 7, 9, 34, 59, 99};
    for (int i = 0; i < array.length; i++) {
      assertEquals(Search.binaryArraySearch(array, array[i]), i);
      assertEquals(Search.binaryArraySearchRec(array, array[i]), i);
    }
  }

  @Test
  void findElementNotInArray() {
    Integer[] array = new Integer[]{3, 6, 7, 9, 34, 59, 99};
    assertEquals(Search.binaryArraySearch(array, 42), -1);
    assertEquals(Search.binaryArraySearch(array, 300), -1);
    assertEquals(Search.binaryArraySearch(array, 1), -1);

    assertEquals(Search.binaryArraySearchRec(array, 42), -1);
    assertEquals(Search.binaryArraySearchRec(array, 300), -1);
    assertEquals(Search.binaryArraySearchRec(array, 1), -1);
  }
}
