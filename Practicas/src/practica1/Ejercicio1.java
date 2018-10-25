package practica1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> res = new ArrayList<>();
		
		System.out.println(iterativoDivisores(12));
		System.out.println(funcionalDivisores(12));
		System.out.println(divisoresRecursivoFinal(12,1,false,res));
	}
	
	public static List<Integer> iterativoDivisores(Integer x)
	{
		List<Integer> res = new ArrayList<>();
		int div = 1;
		
		while(div <= x)
		{
			if(x%div == 0)
				res.add(div);
			
			div++;
		}
		
		return res;
	}
	
	public static List<Integer> funcionalDivisores(Integer x)
	{
	
		return Stream.iterate(1,n->n+1).limit(x).filter(n->x%n==0).collect(Collectors.toList());
	
	}
	
	public static List<Integer> divisoresRecursivoFinal(Integer x, int i, Boolean esDiv, List<Integer> res)
	{
		if(i > x)
			return res;
		else	
			return divisoresRecursivoFinal(x,i+1, x%i == 0 && res.add(i),res);	
	}

}
