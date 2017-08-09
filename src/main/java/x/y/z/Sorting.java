package x.y.z;

public class Sorting {


  public static <T extends Comparable<T>> void bubbleSort(T[] numArray) {
    int n = numArray.length;
    T temp;
    long start = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (numArray[j].compareTo(numArray[j + 1]) > 0) {
          temp = numArray[j];
          numArray[j] = numArray[j + 1];
          numArray[j + 1] = temp;
        }
      }
    }
    System.out.println("BubbleSort. Elapsed time (ms): " + (System.currentTimeMillis() - start));
  }

  public static <T extends Comparable<T>> void insertionSort(T[] array) {
    long start = System.currentTimeMillis();
    T temp;
    if (array.length == 1) {
      return;
    }
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0; j--) {
        if (array[j].compareTo(array[j - 1]) < 0) {
          temp = array[j - 1];
          array[j - 1] = array[j];
          array[j] = temp;
        } else {
          break;
        }
      }
    }
    System.out.println("InsertionSort. Elapsed time (ms): " + (System.currentTimeMillis() - start));
  }

}
