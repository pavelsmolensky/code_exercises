package x.y.z;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BubbleSortTest {
  @Test
  public void sortRandomArray() {
    Integer[] toSort = createRandomIntArray(10);

    Integer[] expected = Arrays.copyOf(toSort, toSort.length);
    Arrays.sort(expected);

    Sorting.bubbleSort(toSort);
    System.out.println("Expected sorted: " + Arrays.toString(expected));
    System.out.println("Bubble sorted: " + Arrays.toString(toSort));
    Assert.assertEquals(expected, toSort);
  }

  @Test
  public void sortEmptyArray() {
    Integer[] toSort = new Integer[]{};
    Sorting.bubbleSort(toSort);
    Assert.assertEquals(toSort.length, 0);
  }

  @Test
  public void sortOneElementArray() {
    Integer[] toSort = new Integer[]{42};
    Sorting.bubbleSort(toSort);
    int first = toSort[0];
    Assert.assertEquals(toSort.length, 1);
    Assert.assertEquals(first, 42);
  }

  @Test
  public void sortSameElementsArray() {
    Integer[] toSort = new Integer[]{42, 42, 42};
    Sorting.bubbleSort(toSort);
    Assert.assertEquals(toSort, new int[]{42, 42, 42});
  }

  @Test
  public void sortHugeArray() {
    Integer[] toSort = createRandomIntArray(99999);

    Integer[] expected = Arrays.copyOf(toSort, toSort.length);
    Arrays.sort(expected);

    Sorting.bubbleSort(toSort);
    Assert.assertEquals(expected, toSort);
  }

  private Integer[] createRandomIntArray(int length) {
    Integer[] result = new Integer[length];
    Random r = new Random();
    IntStream.range(0, length).forEach(i -> result[i] = r.nextInt());
    return result;
  }
}
