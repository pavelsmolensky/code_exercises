package x.y.z;

import java.util.Stack;

public class Strings {

  /**
   * Does string contain all unique characters
   *
   * @param string
   * @return
   */
  public static boolean isUnique(String string) {
    assert string != null;

    boolean result = true;
    char[] chars = string.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      for (int j = i; j < chars.length; j++) {
        if (chars[i] == chars[j]) {
          result = false;
          break;
        }
      }
    }
    return result;
  }

  /**
   * Reverse string (iterative)
   *
   * @param s
   * @return
   */
  public static String reverse(String s) {
    char[] charArray = s.toCharArray();
    int length = charArray.length;
    char tmp;
    for (int i = 0; i < length / 2; i++) {
      tmp = charArray[i];
      charArray[i] = charArray[length - 1 - i];
      charArray[length - 1 - i] = tmp;
    }
    return String.valueOf(charArray);
  }

  /**
   * Reverse string (recursively)
   *
   * @param s
   * @return
   */
  public static String reverseRecur(String s) {
    if (s.length() <= 1) {
      return s;
    } else {
      return s.substring(s.length() - 1) + reverseRecur(s.substring(0, s.length() - 1));
    }
  }

  /**
   * Find if all pairs of braces are closed in correct order. () and {} matters
   *
   * @param string
   * @return
   */
  public static boolean areBracesInValidOrder(String string) {
    Stack<Character> stack = new Stack<>();
    char[] charArray = string.toCharArray();
    boolean result = true;
    for (char c : charArray) {
      if (c == '{' || c == '(') {
        stack.push(c);
      } else if (c == '}' || c == ')') {
        if (stack.empty()) {
          result = false;
          break;
        }
        char openingBrace = stack.pop();
        if ((openingBrace == '(' && c != ')') || openingBrace == '{' && c != '}') {
          result = false;
          break;
        }
      }
    }
    if (!stack.empty()) {
      result = false;
    }
    return result;
  }

}
