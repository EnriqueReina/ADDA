package Ejercicio_cuatro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args)
	{
		List <Integer> l1 = new ArrayList<>();
		List <Integer> l2 = new ArrayList<>();
	
		l1.add(1); l1.add(3); l1.add(-3); l1.add(5); l1.add(100); l1.add(123);		
		l2.add(2); l2.add(-6); l2.add(7); l2.add(8);		
		Collections.sort(l1);
		Collections.sort(l2);
		
		List <Character> l3 = new ArrayList<>();
		List <Character> l4 = new ArrayList<>();
		
		l3.add('a'); l3.add('b'); l3.add('h'); l3.add('k'); l4.add('o');
		l4.add('c'); l4.add('d'); l4.add('z'); l4.add('p');	l4.add('m');
		l4.add('w'); l4.add('x');		
		Collections.sort(l3);
		Collections.sort(l4);
		
		//recursivo final
		
		System.out.println("Recursivo Final: Lista 1 = " + l1 + "  Lista 2 = " + l2 );
		System.out.println(Ejercicio_cuatro.ordenaListaRecursivaFinalReal(l1,l2));
		System.out.println("Recursivo Final: Lista 1 = " + l3 + "  Lista 2 = " + l4 );
		System.out.println(Ejercicio_cuatro.ordenaListaRecursivaFinalReal(l3,l4));
		System.out.println();
		
		//iterativo
		
		System.out.println("Iterativo: Lista 1 = " + l1 + "  Lista 2 = " + l2 );
		System.out.println(Ejercicio_cuatro.ordenaListaIterativo(l1,l2));
		System.out.println("Iterativo: Lista 1 = " + l3 + "  Lista 2 = " + l4 );
		System.out.println(Ejercicio_cuatro.ordenaListaIterativo(l3,l4));
		System.out.println();
		
		//funcional
		
		System.out.println("Funcional: Lista 1 = " + l1 + "  Lista 2 = " + l2 );
		System.out.println(Ejercicio_cuatro.ordenaListaFuncional(l1,l2));
		System.out.println("Funcional: Lista 1 = " + l3 + "  Lista 2 = " + l4 );
		System.out.println(Ejercicio_cuatro.ordenaListaFuncional(l3,l4));
		
	}
}
