package Bags;

public class Ejercicio05 {

	public static void main(String[] args) {
		int N;
		int N2;
		ResizableArrayBag<Integer> bag = new ResizableArrayBag<Integer>(1);
		System.out.println("Escoge un entero");
		System.out.println(bag.add(4));
		while(!bag.isEmpty()) {
			System.out.println("Bolsa: " + bag.toString());
			N = bag.remove();
			System.out.println("Retirado: " + N);
			if(N != 0) {
				N2 = N/2;
				for (int i = 0; i < N; i++) {
					bag.add(N2);
				}
			}
		}
		System.out.println("La bolsa esta vacia!");
	}
	
	/*public int addN(int N) {
		int N2 = N/2;
		for (int i = 0; i < N; i++) {
			
		}
		
	}
	*/

}
