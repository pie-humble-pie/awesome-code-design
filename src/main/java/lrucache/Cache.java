package lrucache;

import lrucache.policy.EvictionPolicy;
import lrucache.storage.Storage;

public class Cache<K, V> {
    int capacity;
    EvictionPolicy<K> evictionPolicy;
    Storage<K,V> storage;

    public Cache(int capacity, EvictionPolicy<K> evictionPolicy, Storage<K,V> storage){
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(K key, V value){
        if(storage.size() == capacity){
            K toEvict  = evictionPolicy.evict();
            storage.remove(toEvict);
        }
        storage.put(key, value);
    }

    public V get(K key){
        evictionPolicy.accessKey(key);
        return storage.get(key);
    }
}


/*

LRU Cache
    - capacity
    - evictionPolicy<Key> : lru, lfu ....
    - Storage<Key, Value> : hashmap, concurrent hash mao, linked hash map etc




 */
