package Bags;

public class EmptyBag {

	public static void main(String[] args) {
		int N;
		ResizableArrayBag<Integer> bag = new ResizableArrayBag<Integer>(1);
		System.out.println(bag.add(3));
		while(!bag.isEmpty()) {
			System.out.println("Bolsa: " + bag.toString());
			N = bag.remove();
			System.out.println("Retirado: " + N);
			if(N == 0) {
			}
			else {
				for (int i = 0; i < N; i++) {
					bag.add(N/2);
				}
			}
		}
	}

}
