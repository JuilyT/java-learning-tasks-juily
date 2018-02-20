package org.LRU.cache;

/**
 * Operations for LRU cacheing 
 * @author juilykumari
 *
 * @param <K>
 * @param <T>
 */
public interface CacheStrategy <K,T>{
	T get(K key);
	void put(K key,T data);
}
