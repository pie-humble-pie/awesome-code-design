package lrucache.storage;

public interface Storage <K,V>{
    void put(K key, V value);
    void remove(K Key);
    V get(K key);
    int size();
}
