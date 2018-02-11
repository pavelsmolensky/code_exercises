package x.y.z;

import org.junit.jupiter.api.Test;
import x.y.z.datastructure.SimpleHashMap;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleHashMapTest {
  @Test
  void test() {
    SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
    HashMap<String, Integer> originalMap = new HashMap<>();

    map.put("one", 1);
    map.put("102", 102);
    map.put("two", 2);
    map.put("two", 3);

    originalMap.put("one", 1);
    originalMap.put("102", 102);
    originalMap.put("two", 2);
    originalMap.put("two", 3);

    for (int i = 0; i < 100; i++) {
      map.put(String.valueOf(i), i);
      originalMap.put(String.valueOf(i), i);
    }
    for (int i = 0; i < 100; i += 2) {
      map.put(String.valueOf(i), i * 1000);
      originalMap.put(String.valueOf(i), i * 1000);
    }

    StringBuilder actual = new StringBuilder();
    StringBuilder original = new StringBuilder();

    for (int i = 0; i < 100; i++) {
      actual.append(map.get(String.valueOf(i))).append(" ");
      original.append(originalMap.get(String.valueOf(i))).append(" ");
    }
    assertEquals(actual.toString(), original.toString());
    //TODO
  }
}
