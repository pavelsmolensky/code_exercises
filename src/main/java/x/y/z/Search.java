package x.y.z;

public class Search {
  /**
   * Binary search in sorted array
   *
   * @param input
   * @param target
   * @return
   */
  public static <T extends Comparable<T>> int binaryArraySearch(T[] input, T target) {
    int low = 0;
    int high = input.length - 1;
    int mid = high / 2;

    while (high >= low) {
      //check middle element of array
      if (input[mid].compareTo(target) == 0) {
        return mid;
      }
      // target is greater than middle element => continue search in the RIGHT half of array
      if (target.compareTo(input[mid]) > 0) {
        low = mid + 1;
      }
      // target is less than middle element => continue search in the LEFT half of array
      else {
        high = mid - 1;
      }
      //recalculate new middle position
      mid = low + (high - low) / 2;
    }
    return -1;
  }

  /**
   * Recursive binary search in sorted array
   *
   * @param input
   * @param target
   * @return
   */
  public static <T extends Comparable<T>> int binaryArraySearchRec(T[] input, T target) {
    return binaryRec(0, input.length-1, input, target);
  }

  private static <T extends Comparable<T>> int binaryRec(int low, int high, T[] array, T target) {
    System.out.println("Lookup range: " + low + ", " + high);

    int mid = low + (high - low) / 2;
     //check middle element of array
    if (array[mid].compareTo(target) == 0) {
      System.out.println("Found at index: " + mid);
      return mid;
    }
    if (low == high) {
      System.out.println("Not found");
      return -1;
    }

    if (target.compareTo(array[mid]) > 0) {
       // target is greater than middle element => continue search in the RIGHT half of array
      return binaryRec(mid + 1, high, array, target);
    } else {
       // target is less than middle element => continue search in the LEFT half of array
      return binaryRec(low, mid - 1, array, target);
    }
  }
}
