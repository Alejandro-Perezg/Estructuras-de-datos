package Map;

public class Entry<K, V> {

	private K key;
	private V value;
	private char status;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
		status = 'a';
	}

	public Entry(K key, V value, char status) {
		this.key = key;
		this.value = value;
		this.status = status;
	}
	
	
	
	public boolean isActive() {
		return status == 'a';
	}

	public boolean isEmpty() {
		return status == 'e';
	}

	public boolean isDeleted() {
		return status == 'd';
	}

	public void delete() {
		status = 'd';
		key = null;
		value = null;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "{key=" + key + ", value=" + value + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Entry) {
			return ((Entry) o).getKey().equals(key);
		}
		return false;
	}

}
