package Map;

import java.util.Arrays;
import java.util.LinkedList;

public class ChainTable<K, V> implements Map<K, V> {
    
    LinkedList<Entry<K, V>>[] buckets;
    LinkedList<Entry<K, V>>[] temp;
    private int size;
    private double entries = 0;
    
    public ChainTable(int size) {
        this.size = size;
        buckets = new LinkedList[size];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(K key) {
        return key.hashCode() % size;
    }
    
    private int prime(int size) {
    	boolean isPrime;
    	while(true) {
    		isPrime = true;
    		for(int i = 2; i < size; i++) {
    			if(size % i == 0) {
    				isPrime = false;
    			}
    		}
    		if(isPrime == true) {
    			return size;
    		}
    		else {
    			size++;
    		}
    	}
    }
    
    
    @Override
    public void add(K key, V value) {
    	if(entries/size >= 1.00) {
    		rehash();
    	}
        int h = hash(key);
        if (!buckets[h].contains(new Entry(key, null))) {
            buckets[h].add(new Entry(key, value));
            entries ++;
        }
    }
    
    private void rehash() {
		size = prime(size * 2);
		temp = buckets.clone();
		buckets = new LinkedList[size];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        for(int i = 0; i < temp.length; i++) {
        	if(temp[i].size() > 0) {
        		for(int k = 0; k < temp[i].size(); k++) {
        			add(temp[i].get(k).getKey(), temp[i].get(k).getValue());
        		}
        	}
        }
		
	}

	@Override
    public V get(K key) {
        int h = hash(key);
        int i = buckets[h].indexOf(new Entry(key, null));
        if (i >= 0) {
            return buckets[h].get(i).getValue();
        }
        return null;
    }
    
    @Override
    public void delete(K key) {
        int h = hash(key);
        buckets[h].remove(new Entry(key, null));
    }
    
    @Override
    public String toString() {
        return Arrays.toString(buckets);
    }
    
}
