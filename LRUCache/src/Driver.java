
public class Driver {

	public static void main(String[] args) {
		LRUCache<String, String> cache = LRUCache.newInstance(2);
		cache.put("Object 1", "entry1");
		cache.put("Object 2", "entry2");
		cache.put("Object 3", "entry3");
		
		System.out.println(cache);
	}
}
