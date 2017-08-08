package x.y.z;

public class Numbers {

  /**
   * Calculate Nth number in Fibonacci sequence
   *
   * @param n
   * @return
   */
  public static int fibonacciNth(int n) {
    assert n > 0;
    if (n == 1 || n == 2) {
      return 1;
    }
    return fibonacciNth(n - 1) + fibonacciNth(n - 2);
  }
}
