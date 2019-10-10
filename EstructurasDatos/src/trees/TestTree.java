package trees;

public class TestTree {
	public static void main(String args[]) {

        Tree<Integer> p = new BST<>();

        System.out.println("Insertando nodos recursivamente.");

        p.add(60);
        p.add(13);
        p.add(85);
        p.add(75);
        p.add(19);
        p.add(2);
        p.add(94);
        p.add(16);
        p.add(10);
        p.add(5);
        p.add(0);
        p.add(34);
        p.add(78);
        p.add(110);
        p.add(99);
        p.add(5);
        p.add(50);
        p.add(150);
        p.add(3);
        p.add(42);
        p.add(57);
        p.add(142);
        p.add(4);
        p.add(38);
        p.add(130);
        p.add(99);
        p.add(50);
        p.add(20);
        p.add(5);
        p.add(35);
        p.add(2);
        p.add(32);
        p.add(27);
        p.add(10);
        p.add(14);
        p.add(7);
        p.add(40);
        p.add(6);
        p.add(142);
        p.add(30);
        p.add(36);
        p.add(46);
        p.add(11);
        p.add(22);
        p.add(5);

        System.out.println("\n***  Arbol con inserciones RECURSIVAS  *** \n");

        System.out.println("\nRecorrido en inOrden: " + p.inOrder());
        System.out.println("\nRecorrido en preOrden: " + p.preOrder());
        System.out.println("\nRecorrido en postOrden: " + p.postOrder());
        System.out.println("\nRecorrido en profundidad: " + p.breadthFirst());

        System.out.println("\n\n***  Probando metodos CONTIENE  *** \n");
        System.out.println("\nContiene el arbol el dato 42?: " + (p.contains(42) ? "SI" : "NO"));
        System.out.println("\nContiene el arbol el dato 34?: " + (p.contains(34) ? "SI" : "NO"));
        System.out.println("\nContiene el arbol el dato 18?: " + (p.contains(18) ? "SI" : "NO"));
        System.out.println("\nContiene el arbol el dato 84?: " + (p.contains(84) ? "SI" : "NO"));

        System.out.println("\nEl arbol tiene " + p.size() + " nodos y " + p.numLeaves() + " hojas.");

        System.out.println("\n\n***  Probando metodo HERMANO  *** \n");
        System.out.println("\nEl hermano de 75 es: " + p.getSibling(75));
        System.out.println("\nEl hermano de 60 es: " + p.getSibling(60));
        System.out.println("\nEl hermano de 175 es: " + p.getSibling(175));
        System.out.println("\nEl hermano de 57 es: " + p.getSibling(57));
        System.out.println("\nEl hermano de 5 es: " + p.getSibling(5));

        System.out.println("\n\n***  Probando metodo PADRE  *** \n");
        System.out.println("\nEl padre de 75 es: " + p.getParent(75));
        System.out.println("\nEl padre de 60 es: " + p.getParent(60));
        System.out.println("\nEl padre de 175 es: " + p.getParent(175));
        System.out.println("\nEl padre de 57 es: " + p.getParent(57));
        System.out.println("\nEl padre de 5 es: " + p.getParent(5));

        System.out.println("\n\n***  Probando metodos MAYOR y MENOR  *** \n");
        System.out.println("\nEl mayor dato del arbol es: " + p.getLargest());
        System.out.println("\nEl menor dato del arbol es: " + p.getLowest());

        System.out.println("\n\n***  Probando metodo ELIMINA  *** \n");
        p.remove(38) ;
        System.out.println("\nBorrando el 38 (nodo hoja): " + p.inOrder());

        p.remove(57);
        System.out.println("\nBorrando el 57 (nodo hoja): " + p.inOrder());

        p.remove(130);
        System.out.println("\nBorrando el 130 (nodo hoja): " + p.inOrder());

        p.remove(34);
        System.out.println("\nBorrando el 34 (nodo con un hijo): " + p.inOrder());

        p.remove(100);
        System.out.println("\nBorrando el 100 (nodo inexistente): " + p.inOrder());

        p.remove(85);
        System.out.println("\nBorrando el 85 (nodo con dos hijos): " + p.inOrder());

        p.remove(60);
        System.out.println("\nBorrando el 60 (nodo raiz): " + p.inOrder());

        System.out.println("\n\n***  Probando metodo CLEAR  *** \n");
        System.out.println("\nBorrando todos los datos del arbol... ");
        p.clear();

        System.out.println("\n\nInsertando el 85 (nodo raiz)... ");
        p.add(85);
        System.out.println("\nRecorrido en inOrden: " + p.inOrder());
        p.remove(85);
        System.out.println("\nBorrando el 85 (nodo raiz SIN hijos): " + p.inOrder());

        System.out.println("\nBorrando todos los datos del arbol... ");
        p.clear();

        System.out.println("\n\nInsertando el 36 (nodo raiz)... ");
        p.add(36);

        System.out.println("\nInsertando el 74 ... ");
        p.add(74);
        System.out.println("\nRecorrido en inOrden: " + p.inOrder());

        p.remove(36);
        System.out.println("\nBorrando el 36 (nodo raiz con hijo derecho): " + p.inOrder());

        System.out.println("\nBorrando todos los datos del arbol... ");
        p.clear();

        System.out.println("\nInsertando el 54 (nodo raiz)... ");
        p.add(54);
        System.out.println("\nInsertando el 22 ... ");
        p.add(22);
        System.out.println("\nRecorrido en inOrden: " + p.inOrder());
        p.remove(54);
        System.out.println("\nBorrando el 54 (nodo raiz con hijo izquierdo): " + p.inOrder());

        System.out.println("\n\n");

    }
}
