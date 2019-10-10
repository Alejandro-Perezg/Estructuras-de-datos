package Bags;

public class TestBag {
	public static void main(String[] args) {
		ResizableArrayBag<Integer> bag = new ResizableArrayBag<Integer>(1);
		System.out.println("Bag is full? " + bag.isFull());
        System.out.println("Bag is empty? " + bag.isEmpty());
        System.out.println(bag.add(10));
        System.out.println(bag.add(20));
        System.out.println(bag.add(10));
        System.out.println(bag.add(5));
        System.out.println(bag.add(8));
        System.out.println(bag.add(10));
        System.out.println(bag.add(8));
        System.out.println(bag.add(10));
        System.out.println("Bag is: " + bag.toString());
        System.out.println(bag.removeEvery(10));
        System.out.println("Bag is: " + bag.toString());
	}

}
