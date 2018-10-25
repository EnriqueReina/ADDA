package practica2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio_dos {

	public static void main(String[] args) {
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		l1.add(2);
		l1.add(2);
		l1.add(5);
		l1.add(10);
		l1.add(1);
		l1.add(4);
		
		l2.add(7);
		l2.add(7);
		l2.add(10);
		l2.add(20);
		l2.add(13);
		l2.add(15);
		
		System.out.println(comparaListaRealesIterativo(l1,l2));
		System.out.println(comparaListaRealesRecursivoFuncional(l1,l2));
		System.out.println(comparaListaRealesRecursivoFinal(l1,l2,0,false));
	}

	public static Boolean mismoIncremento(int i, List<Integer> l1, List<Integer> l2)
	{
		int dif1 = l1.get(i+1) - l1.get(i);
		int dif2 = l2.get(i+1) - l2.get(i);
		
		if(dif1 == 0 &&dif2 == 0|| dif1 > 0 && dif2 > 0 || dif1 < 0 && dif2 < 0)
			return true;
		else
			return false;
	}
	
	public static Boolean comparaListaRealesIterativo(List<Integer> l1, List<Integer> l2)
	{
		Boolean res = false;
		int i = 0;
		int tam = l1.size();
		
		while(i < tam-1)
		{
			if(mismoIncremento(i,l1,l2))
				res=true;
			else
				return false;			
			i++;
		}
		
		return res;
	}
	
	public static Boolean comparaListaRealesRecursivoFuncional(List<Integer> l1, List<Integer> l2)
	{
		return Stream.iterate(0,x->x+1).limit(l1.size()-1).allMatch(x->mismoIncremento(x, l1, l2));
	}
	
	public static Boolean comparaListaRealesRecursivoFinal(List<Integer> l1, List<Integer> l2, int i, Boolean res)
	{
		if(i>l1.size()-2)
			return res;
		else
			return comparaListaRealesRecursivoFinal(l1,l2,i+1,mismoIncremento(i,l1,l2));
	}
}
