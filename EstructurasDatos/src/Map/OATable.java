package Map;

import java.util.Arrays;

public class OATable<K, V> implements Map<K, V> {
	
	private int size;
    private Entry<K, V>[] table;

    public OATable(int size) {
        this.size = size;
        table = new Entry[size];
        for (int i = 0; i < table.length; i++) {
            table[i] = new Entry(null, null, 'e');
        }
    }

    private int hash(K key) {
        return key.hashCode() % size;
    }

    private int probe(int i) {
        return (i + 1) % size;
    }

    @Override
    public void add(K key, V value) {
    	if(get(key)!= null)return;
        int h = hash(key);
        int s = h;
        while (table[h].isActive()) {
            if (table[h].equals(new Entry(key, null))) {
                return;
            }
            h = probe(h);
            if (s == h) {
                return;
            }
        }
        table[h] = new Entry(key, value);
    }

    @Override
    public V get(K key) {
        int h = hash(key);
        int s = h;
        while (table[h].isActive() || table[h].isDeleted()) {
            if (table[h].isActive() && table[h].equals(new Entry(key, null))) {
                return table[h].getValue();
            }
            h = probe(h);
            if (s == h) {
                return null;
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
    	 int h = hash(key);
         int s = h;
         while (table[h].isActive() || table[h].isDeleted()) {
             if (table[h].isActive() && table[h].equals(new Entry(key, null))) {
                 table[h].delete();
             }
             h = probe(h);
             if (s == h) {
                 return ;
             }
         }
     }
    
 

    @Override
    public String toString() {
        return Arrays.toString(table);
    }


}
