package x.y.z;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortTest {
   @Test(dataProvider = "sortings")
   public void sortRandomArray(Consumer<Integer[]> sortingFunction) {
      Integer[] toSort = createRandomIntArray(10);

      Integer[] expected = Arrays.copyOf(toSort, toSort.length);
      Arrays.sort(expected);

      sortingFunction.accept(toSort);
      Assert.assertEquals(expected, toSort);
   }

   @Test(dataProvider = "sortings")
   public void sortEmptyArray(Consumer<Integer[]> sortingFunction) {
      Integer[] toSort = new Integer[] {};
      sortingFunction.accept(toSort);
      Assert.assertEquals(toSort.length, 0);
   }

   @Test(dataProvider = "sortings")
   public void sortOneElementArray(Consumer<Integer[]> sortingFunction) {
      Integer[] toSort = new Integer[] { 42 };
      sortingFunction.accept(toSort);
      int first = toSort[0];
      Assert.assertEquals(toSort.length, 1);
      Assert.assertEquals(first, 42);
   }

   @Test(dataProvider = "sortings")
   public void sortSameElementsArray(Consumer<Integer[]> sortingFunction) {
      Integer[] toSort = new Integer[] { 42, 42, 42 };
      sortingFunction.accept(toSort);
      Assert.assertEquals(toSort, new Integer[] { 42, 42, 42 });
   }

   @Test(dataProvider = "sortings")
   public void sortHugeArray(Consumer<Integer[]> sortingFunction) {
      Integer[] toSort = createRandomIntArray(99999);

      Integer[] expected = Arrays.copyOf(toSort, toSort.length);
      Arrays.sort(expected);

      sortingFunction.accept(toSort);
      Assert.assertEquals(expected, toSort);
   }

   private Integer[] createRandomIntArray(int length) {
      Integer[] result = new Integer[length];
      Random r = new Random();
      IntStream.range(0, length).forEach(i -> result[i] = r.nextInt());
      return result;
   }

   @DataProvider
   public Object[][] sortings() {
      return new Object[][] {
            { (Consumer<Integer[]>) Sorting::insertionSort },
            { (Consumer<Integer[]>) Sorting::bubbleSort },
            { (Consumer<Integer[]>) Sorting.MergeSort::mergeSort },
            { (Consumer<Integer[]>) Sorting::selectionSort } };
   }
}
