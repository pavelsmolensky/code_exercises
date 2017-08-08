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
    System.out.println("Elapsed time (ms): " + (System.currentTimeMillis() - start));
  }

}
