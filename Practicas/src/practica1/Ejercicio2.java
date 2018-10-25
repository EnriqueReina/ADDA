package practica1;

import java.util.Iterator;
import java.util.List;

import us.lsi.common.ListMultimap;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static ListMultimap<Cuadrante, Punto2D> agrupaPuntosPorCuadrante(List<Punto2D> lista)
	{
		ListMultimap<Cuadrante, Punto2D> res = new ListMultimap<>();
		
		Iterator<Punto2D> it1 = lista.iterator();
		
		Punto2D paux = null;
		
		while(it1.hasNext())
		{
			paux = it1.next();
			
			res.put(paux.getCuadrante(), paux);
		}
		
		return res;
	}
	
	public static ListMultimap<Cuadrante, Punto2D> agrupaPuntosPorCuadranteFuncional(List<Punto2D> lista)
	{
		ListMultimap<Cuadrante, Punto2D> res = new ListMultimap<>();
		
		lista.forEach(x->res.put(x.getCuadrante(),x));
		
		return res;
	}

}
