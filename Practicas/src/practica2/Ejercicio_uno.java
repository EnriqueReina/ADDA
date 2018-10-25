package practica2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio_uno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Double> res = new ArrayList<>();
		
		System.out.println(CuadradoPrimoIterativo(10));
		System.out.println(CuadradoPrimoFuncional(10));
		System.out.println(CudradoPrimoRecursivoFinal(10,1,false,res));
		
	}

	public static Boolean esPrimo(int x)
	{
		int i = 1;
		int nod = 0;
		
		while(i <= x)
		{
			if(x%i == 0)
				nod++;
			
			i++;
		}
		
		if(nod==2)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	public static List<Double> CuadradoPrimoIterativo(int x)
	{
		List<Double> res = new ArrayList<>();
		int i = 1;
		
		while(i <= x)
		{
			if(esPrimo(i))
				res.add(Math.pow(i, 2));			
			i++;
		}
		
		return res;
	}
	
	public static List<Double> CuadradoPrimoFuncional(int x)
	{
		List<Double> res = new ArrayList<>();
		Stream.iterate(0,n->n+1).limit(x).filter(n->esPrimo(n)).forEach(b->res.add(Math.pow(b, 2)));
		return res;
	}
	
	public static List<Double> CudradoPrimoRecursivoFinal(int x, int i, Boolean esPrimo, List<Double> res)
	{
		if(i>x)
			return res;
		else
			return CudradoPrimoRecursivoFinal(x,i+1,esPrimo(i) && res.add(Math.pow(i, 2)),res);
	}
}
