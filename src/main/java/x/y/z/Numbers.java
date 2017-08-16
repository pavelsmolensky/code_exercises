package x.y.z;

public class Numbers {

   /**
    * Calculate Nth number in Fibonacci sequence
    *
    * @param n
    * @return
    */
   public static int fibonacciNthRec(int n) {
      if (n <= 2) {
         return 1;
      }
      return fibonacciNthRec(n - 1) + fibonacciNthRec(n - 2);
   }

   public static int fibonacciNth(int n) {
      int current = 1, previous = 1;
      int temp;

      if (n <= 2) {
         return 1;
      }
      for (int i = 3; i <= n; i++) {
         temp = current;
         current = current + previous;
         previous = temp;
      }
      return current;

   }
}
