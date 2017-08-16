package x.y.z.datastructure;

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
      //get MapEntry from bucket using hash of the key argument
      MapEntry<K, V> entryInBucket = buckets[hash];
      //no such hash in array => insert MapEntry into hash position
      if (entryInBucket == null) {
         buckets[hash] = entry;
      }
      //there is already an entry in the array with hash, that is equal to argument's hash => replace old element
      else if (entryInBucket.getKey().equals(key)) {
         buckets[hash] = entry;
         entry.setNext(entryInBucket.getNext());
      }
      //there is already an entry in the array, but new and old entries are not equal => traverse through the chain of entries
      else {
         while (entryInBucket.getNext() != null) {
            MapEntry<K, V> current = entryInBucket;
            entryInBucket = entryInBucket.getNext();
            //found equal key => replace old entry with new one and reassign the next links
            if (entryInBucket.getKey().equals(key)) {
               current.setNext(entry);
               entry.setNext(entryInBucket.getNext());
               return;
            }
         }
         //traversed through all items in chain and didn't find an equal entry to replace => add entry to the end of the chain
         entryInBucket.setNext(entry);
      }
   }

   public V get(K key) {
      int hash = key.hashCode() % CAPACITY;
      //get MapEntry from bucket using hash of the key argument
      MapEntry<K, V> entry = buckets[hash];
      if (entry == null) {
         return null;
      }
      //traverse through the chain of entries comparing entries for equality
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