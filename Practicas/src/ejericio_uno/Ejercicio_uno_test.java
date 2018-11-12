package ejericio_uno;

import java.util.ArrayList;
import java.util.List;


public class Ejercicio_uno_test {
	
	 public static void main(String[] args) {
	        
	        List<String> l = new ArrayList<>();
	        
	        String s1 = "qwerty";
	        String s2 = "qwertY";
	        String s3 = "qwerTY";
	        String s4 = "qweRTY";
	        String s5 = "qwERTY";
	        String s6 = "qWERTY";
	        String s7 = "QWERTY";
	        
	        l.add(s1);
	        l.add(s2);
	        l.add(s3);
	        l.add(s4);
	        l.add(s5);
	        l.add(s6);  
	        l.add(s7);  
	        
	        System.out.println("Iterativo para encontrar la palabra con mas minusculas: " + l);
	        System.out.println(Ejercicio_uno.buscMasCaracMinuscIterativo(l));
	        System.out.println("Funcional para encontrar la palabra con mas minusculas: " + l);
	        System.out.println(Ejercicio_uno.buscMasCaracMinuscFuncional(l));
	        System.out.println("Recursivo para encontrar la palabra con mas minusculas: " + l);
	        System.out.println(Ejercicio_uno.buscMasCaracMinuscRecursivoFinal(l,0,0,0,l.get(0)));
	 
	    }
}
