// 런타임에서 객체 표현

record Entry<K,V> (int hash, K key, V value, Entry<K,V> next) {}