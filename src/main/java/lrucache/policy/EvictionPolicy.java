package lrucache.policy;

public interface EvictionPolicy<K>{
    void accessKey(K key);
    K evict();
}
