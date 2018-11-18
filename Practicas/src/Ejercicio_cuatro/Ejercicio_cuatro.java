package Ejercicio_cuatro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ejercicio_cuatro {
	
	//ITERATIVO
		
	public static <T extends Comparable<T>> List<T> ordenaListaIterativo(List<T> l1, List<T> l2)
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
	public static <T extends Comparable<T>> List<T> ordenaListaFuncional(List<T> l,List<T> f)
	{
		List<T> res = new ArrayList<>();
	
		List<T> l1 = l;
		List<T> l2 = f;
		
		IntStream.iterate(0, i->!l1.isEmpty() || !l2.isEmpty(), i->i)
		.forEach(i->
		{				
			if(!l1.isEmpty()&&l2.stream().allMatch(fecha->fecha.compareTo(l1.get(i))>0))
			{
				res.add(l1.get(i));
				l1.remove(i);
			}
			else if(!l2.isEmpty())
			{
				res.add(l2.get(i));
				l2.remove(i);
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
