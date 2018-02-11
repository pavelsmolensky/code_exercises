package x.y.z;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
  @ParameterizedTest
  @MethodSource("sortings")
  void sortRandomArray(Consumer<Integer[]> sortingFunction) {
    Integer[] toSort = createRandomIntArray(10);

    Integer[] expected = Arrays.copyOf(toSort, toSort.length);
    Arrays.sort(expected);

    sortingFunction.accept(toSort);
    assertArrayEquals(expected, toSort);
  }


  @ParameterizedTest
  @MethodSource("sortings")
  void sortEmptyArray(Consumer<Integer[]> sortingFunction) {
    Integer[] toSort = new Integer[]{};
    sortingFunction.accept(toSort);
    assertEquals(toSort.length, 0);
  }

  @ParameterizedTest
  @MethodSource("sortings")
  void sortOneElementArray(Consumer<Integer[]> sortingFunction) {
    Integer[] toSort = new Integer[]{42};
    sortingFunction.accept(toSort);
    int first = toSort[0];
    assertEquals(toSort.length, 1);
    assertEquals(first, 42);
  }

  @ParameterizedTest
  @MethodSource("sortings")
  void sortSameElementsArray(Consumer<Integer[]> sortingFunction) {
    Integer[] toSort = new Integer[]{42, 42, 42};
    sortingFunction.accept(toSort);
    assertArrayEquals(toSort, new Integer[]{42, 42, 42});
  }

  @ParameterizedTest
  @MethodSource("sortings")
  void sortHugeArray(Consumer<Integer[]> sortingFunction) {
    Integer[] toSort = createRandomIntArray(99999);

    Integer[] expected = Arrays.copyOf(toSort, toSort.length);
    Arrays.sort(expected);

    sortingFunction.accept(toSort);
    assertArrayEquals(expected, toSort);
  }

  private Integer[] createRandomIntArray(int length) {
    Integer[] result = new Integer[length];
    Random r = new Random();
    IntStream.range(0, length).forEach(i -> result[i] = r.nextInt());
    return result;
  }

  //@DataProvider
  private static Consumer[] sortings() {
    return new Consumer[]{
        (Consumer<Integer[]>) Sorting::insertionSort,
        (Consumer<Integer[]>) Sorting::bubbleSort,
        (Consumer<Integer[]>) Sorting.MergeSort::mergeSort,
        (Consumer<Integer[]>) Sorting::selectionSort};
  }
}
