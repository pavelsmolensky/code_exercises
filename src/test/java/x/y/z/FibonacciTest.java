package x.y.z;

import org.testng.annotations.Test;

public class FibonacciTest {
  @Test
  public void test(){
    System.out.println(Numbers.fibonacciNth(5));
    System.out.println(Numbers.fibonacciNthRec(5));
  }
  //TODO
}
