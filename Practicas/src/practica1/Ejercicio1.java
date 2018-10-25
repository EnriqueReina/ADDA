package practica1;

import java.util.ArrayList;
import java.util.List;


public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(iterativoDivisores(12));
	}
	
	public static List<Integer> iterativoDivisores(Integer x)
	{
		List<Integer> res = new ArrayList<>();
		int div = x;
		
		while(div > 0)
		{
			if(x%div == 0)
				res.add(div);
			
			div--;
		}
		
		return res;
	}
	
	public static List<Integer> funcionalDivisores(Integer x)
	{
		List<Integer> res = new ArrayList<>();
		
		return res;
	}

}
