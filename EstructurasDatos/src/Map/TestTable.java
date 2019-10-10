package Map;

public class TestTable {

	public static void main(String[] args) {
		Map<String, Integer> ht = new ChainTable<>(5);
		ht.add("one", 1);
        ht.add("two", 2);
        ht.add("three", 3);
        ht.add("four", 4);
        ht.add("five", 5);
        System.out.println("Table: " + ht);
        ht.add("six", 6);
        System.out.println("Table: " + ht);
		
        /*Map<String, Integer> ht = new OATable<>(5);
        ht.add("one", 1);
        ht.add("one", 2);
        ht.add("two", 2);
        ht.add("three", 3);
        ht.add("four", 4);
        ht.add("five", 5);
        System.out.println("Table: " + ht);
        System.out.println("");

        System.out.println("Value for 'one': " + ht.get("one"));
        System.out.println("Value for 'two': " + ht.get("two"));
        System.out.println("Value for 'three': " + ht.get("three"));
        System.out.println("Value for 'four': " + ht.get("four"));
        System.out.println("Value for 'five': " + ht.get("five"));
        System.out.println("Value for 'six': " + ht.get("six"));
        System.out.println("");

        ht.delete("two");
        System.out.println("Table after deleting 'two': " + ht);
        System.out.println("Value for 'one': " + ht.get("one"));
        System.out.println("Value for 'two': " + ht.get("two"));
        System.out.println("Value for 'three': " + ht.get("three"));
        System.out.println("Value for 'four': " + ht.get("four"));
        System.out.println("Value for 'five': " + ht.get("five"));
        System.out.println("Value for 'six': " + ht.get("six"));
        System.out.println("");

        ht.delete("four");
        System.out.println("Table after deleting 'four': " + ht);
        System.out.println("Value for 'one': " + ht.get("one"));
        System.out.println("Value for 'two': " + ht.get("two"));
        System.out.println("Value for 'three': " + ht.get("three"));
        System.out.println("Value for 'four': " + ht.get("four"));
        System.out.println("Value for 'five': " + ht.get("five"));
        System.out.println("Value for 'six': " + ht.get("six"));
        System.out.println("");
        */
	}

}
