package practica_individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio_dos {
	
	public static void main(String[] args)
	{
		List <Integer> l1 = new ArrayList<>();
		List <Integer> l2 = new ArrayList<>();
		
		
		//1,3,-3,5
		l1.add(1);
		l1.add(3);
		l1.add(-3);
		l1.add(5);
		
		//2,-6,7,8
		l2.add(2);
		l2.add(-6);
		l2.add(7);
		l2.add(8);
		
		Collections.sort(l1);
		Collections.sort(l2);
		
		//================================================================
		
		List <Character> l3 = new ArrayList<>();
		List <Character> l4 = new ArrayList<>();
		
		l3.add('a');
		l3.add('b');
		l3.add('h');
		l3.add('k');
	
		l4.add('o');
		l4.add('c');
		l4.add('d');
		l4.add('z');
		l4.add('p');
		l4.add('m');
		l4.add('w');
		l4.add('x');
		
		
		Collections.sort(l3);
		Collections.sort(l4);
		
		System.out.println(ordenaListaIterativo(l1,l2));
		System.out.println(ordenaListaIterativo(l3,l4));
	}
	
	public static <T extends Comparable<T>> Boolean estaOrdenada(List<T> l1)
	{
		int i = 0;
		Boolean res = false;
		
		while(i < l1.size()-1)
		{
			if(l1.get(i).compareTo(l1.get(i+1)) < 0)
			{
				res = true;
				i++;
			}
			else
			{
				res = false;
				break;
			}
		}
		
		return res;
	}
	
	public static <T extends Comparable<T>> List<T> ordenaListaIterativo(List<T> l1,List<T> l2)
	{		
		List<T> res = new ArrayList<>();
		
		res.addAll(l1);
		res.addAll(l2);		
		
		while(!estaOrdenada(res))
		{
			int i = 0;
			while(i < res.size()-1)
			{				
				if(res.get(i).compareTo(res.get(i+1)) > 0)
				{
					res.add(i,res.get(i+1));
					res.remove(i+2);
				}				
				i++;
			}		
		}		
		return res;
	}
}
