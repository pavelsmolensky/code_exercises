package x.y.z;

/**
 * Basic implementation of HashMap with only 2 methods
 * @param <K>
 * @param <V>
 */
public class SimpleHashMap<K, V> {
   private static int CAPACITY = 100;
   private MapEntry<K, V>[] buckets;

   public SimpleHashMap() {
      buckets = new MapEntry[CAPACITY];
   }

   public void put(K key, V value) {
      MapEntry<K, V> entry = new MapEntry<>(key, value);
      int hash = entry.getKey().hashCode() % CAPACITY;
      MapEntry<K, V> entryInBucket = buckets[hash];
      if (entryInBucket == null) {
         buckets[hash] = entry;
      } else if (entryInBucket.getKey().equals(key)) {
         buckets[hash] = entry;
         entry.setNext(entryInBucket.getNext());
      } else {
         while (entryInBucket.getNext() != null) {
            MapEntry<K, V> current = entryInBucket;
            entryInBucket = entryInBucket.getNext();
            if (entryInBucket.getKey().equals(key)) {
               current.setNext(entry);
               entry.setNext(entryInBucket.getNext());
               return;
            }
         }
         entryInBucket.setNext(entry);
      }
   }

   public V get(K key) {
      int hash = key.hashCode() % CAPACITY;
      MapEntry<K, V> entry = buckets[hash];
      if (entry == null) {
         return null;
      }
      while (entry != null) {
         if (entry.getKey().equals(key)) {
            return entry.getValue();
         }
         entry = entry.getNext();
      }
      return null;
   }

   static class MapEntry<K, V> {
      private K        key;
      private V        value;
      private MapEntry next;

      public MapEntry(K key, V value) {
         this.key = key;
         this.value = value;
      }

      public K getKey() {
         return key;
      }

      public void setKey(K key) {
         this.key = key;
      }

      public V getValue() {
         return value;
      }

      public void setValue(V value) {
         this.value = value;
      }

      public MapEntry getNext() {
         return next;
      }

      public void setNext(MapEntry next) {
         this.next = next;
      }

      @Override
      public String toString() {
         return "MapEntry{" + "key=" + key + ", value=" + value + '}';
      }
   }
}