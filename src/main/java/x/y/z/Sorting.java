package x.y.z;

public class Sorting {

   public static <T extends Comparable<T>> void bubbleSort(T[] array) {
      int n = array.length;
      T temp;
      long start = System.currentTimeMillis();
      //repeat for each element of array
      for (int i = 0; i < n; i++) {
         //at each iteration one element moves to the sorted right side of array
         for (int j = 0; j < n - i - 1; j++) {
            if (array[j].compareTo(array[j + 1]) > 0) {
               temp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = temp;
            }
         }
      }
      System.out.println("BubbleSort. Elapsed time (ms): " + (System.currentTimeMillis() - start));
   }
   //-----------

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      long start = System.currentTimeMillis();
      T temp;
      if (array.length == 1) {
         return;
      }
      for (int i = 1; i < array.length; i++) {
         //at each iteration get current value of array and move it to the left part until it is less than its left neighbour
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
   //-----------

   static class MergeSort {
      private static Comparable[] tempArray;

      public static void mergeSort(Comparable[] array) {
         long start = System.currentTimeMillis();
         tempArray = new Comparable[array.length];
         mergeSort(array, 0, array.length - 1);
         System.out.println("MergeSort. Elapsed time (ms): " + (System.currentTimeMillis() - start));
      }

      private static void mergeSort(Comparable[] array, int low, int high) {
         if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
         }
      }

      private static void merge(Comparable[] array, int low, int mid, int high) {
         for (int i = low; i <= high; i++) {
            tempArray[i] = array[i];
         }

         int leftIndex = low;
         int rightIndex = mid + 1;

         for (int k = low; k <= high; k++) {
            if (leftIndex > mid) {
               array[k] = tempArray[rightIndex++];
            } else if (rightIndex > high) {
               array[k] = tempArray[leftIndex++];
            } else if (tempArray[leftIndex].compareTo(tempArray[rightIndex]) < 0) {
               array[k] = tempArray[leftIndex++];
            } else {
               array[k] = tempArray[rightIndex++];
            }
         }

      }
   }

}
