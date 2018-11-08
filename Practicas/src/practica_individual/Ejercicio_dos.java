package practica_individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


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
		l1.add(100);
		l1.add(123);
		
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
		
		//recursivo final
		
		System.out.println("Recursivo Final: Lista 1 = " + l1 + "  Lista 2 = " + l2 );
		System.out.println(ordenaListaRecursivaFinalReal(l1,l2));
		System.out.println("Recursivo Final: Lista 1 = " + l3 + "  Lista 2 = " + l4 );
		System.out.println(ordenaListaRecursivaFinalReal(l3,l4));
		System.out.println();
		
		//iterativo
		
		System.out.println("Iterativo: Lista 1 = " + l1 + "  Lista 2 = " + l2 );
		System.out.println(ordenaListaIterativo(l1,l2));
		System.out.println(ordenaListaIterativoDos(l1,l2));
		System.out.println("Iterativo: Lista 1 = " + l3 + "  Lista 2 = " + l4 );
		System.out.println(ordenaListaIterativo(l3,l4));
		System.out.println(ordenaListaIterativoDos(l3,l4));
		System.out.println();
		
		//funcional
		
		System.out.println("Funcional: Lista 1 = " + l1 + "  Lista 2 = " + l2 );
		System.out.println(ordenaListaFuncional(l1,l2));
		System.out.println(ordenaListaFuncional(l3,l4));
		
	}
	
	//ITERATIVO
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
	
	public static <T extends Comparable<T>> List<T> ordenaListaIterativoDos(List<T> l1, List<T> l2)
	{
		List<T> lista1 = l1;
		List<T> lista2 = l2;
		
		List<T> res = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		
		while(i < lista1.size() && j < lista2.size())
		{
			T t1 = lista1.get(i);
			T t2 = lista2.get(j);
			
			if(t1.compareTo(t2) > 0)
			{
				res.add(t2);
				j++;
			}
			else if(t1.compareTo(t2) == 0)
			{
				res.add(t1);
				res.add(t2);
				i++;
				j++;
			}
			else
			{
				res.add(t1);
				i++;
			}
		}
		
		if(i == lista1.size())
		{
			res.addAll(lista2.subList(j, lista2.size()));
		}
		
		if(j == lista2.size())
		{
			res.addAll(lista1.subList(i, lista1.size()));
		}
		
		return res;
	}
	
	//FUNCIONAL	
	//FUNCIONAL
	public static <T extends Comparable<T>> List<T> ordenaListaFuncional(List<T> l1,List<T> l2)
	{
		List<T> res = new ArrayList<>();
		
		List<T> aux1 = l1;
		List<T> aux2 = l2;
		
		IntStream.iterate(0, i->!aux1.isEmpty() || !aux2.isEmpty(), i->i+0).forEach(
				i->
				{
				
					if(!aux1.isEmpty()&&aux2.stream().allMatch(j->j.compareTo(aux1.get(i))>0))
					{
						res.add(aux1.get(i));
						aux1.remove(i);
					}
					else if(!aux2.isEmpty())
					{
						res.add(aux2.get(i));
						aux2.remove(i);
					}
				});
		
		return res;
	}
	
	//RECURSIVO FINAL
	
	public static <T extends Comparable<T>> List<T> ordenaListaRecursivaFinalReal(List<T> l1, List<T> l2)
	{
		List <T> lista1 = l1;
		List <T> lista2 = l2;
		List<T> res = new ArrayList<>();
		return ordenaListaRecursivaFinal(lista1,lista2,0,0,false,res);
	}
	
	//RECURSIVO
	public static <T extends Comparable<T>> List<T> ordenaListaRecursivaFinal
	(List<T> l1, List<T> l2, int i, int j, Boolean a, List<T> res)
	{		
		if(i == l1.size())
			res.addAll(l2.subList(j,l2.size()));
		else if(j == l2.size())
			res.addAll(l1.subList(i,l1.size()));
		else
		{
			if(l1.get(i).compareTo(l2.get(j)) > 0)
				return ordenaListaRecursivaFinal(l1,l2,i,j+1,res.add(l2.get(j)),res);
			else if(l1.get(i).compareTo(l2.get(j)) == 0)
				return ordenaListaRecursivaFinal(l1,l2,i+1,j+1,res.add(l2.get(j)),res);
			else
				return ordenaListaRecursivaFinal(l1,l2,i+1,j,res.add(l1.get(i)),res);
		}
		
		return res;
	}
	
}
