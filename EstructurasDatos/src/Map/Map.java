package Map;

public interface Map< K, V> {
	//K is the data type of the key
	//V is the data type of the value
	
	void add(K key, V value);
	
	V get (K key);
	
	void delete(K key); 

}
