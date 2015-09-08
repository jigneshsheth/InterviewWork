import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Paul
 *
 * @param <K>
 * @param <V>
 * Purpose: Build a LRU cache in Java.
 * About: An LRU cache is a fixed size cache
 * block that stores most recently used memory
 * blocks locally instead of reading from
 * disk as that is inefficient.
 * Implementation: Each cache entry has a 
 * key, value pair where each key is entry
 * and the value is what that key holds.
 * LRU needs to evict the least recently used
 * cache block in cache list and replace it with
 * newer one. This is why a linked hash map is used here.
 * Benefit: LinkedHashMap maintains insertion order while
 * also having the capability of removing eldest element.
 * We override that method so that when size of the entries
 * goes over how much we can hold we know to evict.
 * 
 * Driver shows how this is used. Entry 1 is not displayed
 * because it was the least recently used entry.
 */

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
	
	private int cache_size;
	private static final long serialVersionUID = 1L;
	
	/* Constructor */
	private LRUCache(int size) {
		// Super constructor, giving it cache size, and 
		// default load factor.
		super(size, 0.75f, true);
		this.cache_size = size;
	}
	
	/* Create new instance of the cache */
	public static <K,V>LRUCache<K,V> newInstance(int size) {
		return new LRUCache<K,V>(size);
	}
	
	/* Set a max on the cache size */
	public void setMax(int size) {
		this.cache_size = size;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > this.cache_size;
	}
}
