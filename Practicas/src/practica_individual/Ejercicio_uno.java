package practica_individual;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class Ejercicio_uno {
	 
	    public static void main(String[] args) {
	        
	        List<String> l = new ArrayList<>();
	        
	        String s1 = "Holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	        String s2 = "Hoolaaaaaaaaaaaaaaaaaa";
	        String s3 = "olaCaracolaBertolaMakaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	        String s4 = "nfesnfjksnfkjsfkjbshfvshf fkesjefjke  eksjf hkjse";
	        String s5 = "nkesjefjke  eksjf hkjeeeeeeeee";
	        
	        l.add(s1);
	        l.add(s2);
	        l.add(s3);
	        l.add(s4);
	        l.add(s5);
	        
	        System.out.println(buscMasCaracMinuscIterativo(l));
	        System.out.println(buscMasCaracMinuscFuncional(l));
	        System.out.println(buscMasCaracMinuscRecursivoFinal(l,0,0,0,l.get(0)));
	 
	    }
	    
	    public static Integer cuentaCaracteres(String s)
	    {
	        int i = 0;
	        int count = 0;
	        while(i < s.length())
	        {
	            if(Character.isLowerCase(s.charAt(i)))
	                count++;
	            
	            i++;
	        }
	        
	        return count;
	    }
	    
	    public static Integer cuentaCarcateresFuncional(String s)
	    {
	    	return (int) Stream.iterate(0, x->x+1).limit(s.length()).filter(x->Character.isLowerCase(s.charAt(x))).count();
	    }
	    
	    public static String buscMasCaracMinuscIterativo(List<String> l)
	    {
	        String res = "";
	        int i = 0;
	        int newCount = 0;
	        
	        while(i < l.size())
	        {
	            if(cuentaCaracteres(l.get(i)) > newCount)
	            {
	                newCount = cuentaCaracteres(l.get(i));
	                res = l.get(i);
	            }
	            
	            i++;
	        }
	        
	        return res;
	    }
	    
	    public static String buscMasCaracMinuscFuncional(List<String> l)
	    {
	        String res = "";
	        int as = Stream.iterate(0,x->x+1).limit(l.size()).max(Comparator.comparing(x->cuentaCarcateresFuncional(l.get(x)))).get();
	                
	        res = l.get(as);
	        
	        return res;
	    }
	    
	    public static Integer cuentaCaracteresRecursivo(String s, int i, int res)
	    {
	    	if(i >= s.length())
	    		return res;
	    	else
	    	{
	    		if(Character.isLowerCase(s.charAt(i)))
	    			return cuentaCaracteresRecursivo(s, i+1,res+1);
	    		else
	    			return cuentaCaracteresRecursivo(s, i+1,res);
	    	}
	    }
	    
	    public static String buscMasCaracMinuscRecursivoFinal
	    (List<String> l, int i, int acu, int a, String res)
	    {	        
	        if(i < l.size())
	        {
	        	int temp = cuentaCaracteresRecursivo(l.get(i),0,0);
	            if( temp > acu)
	            {
	                acu = temp;
	                a = i;
	            }
	            
	            return buscMasCaracMinuscRecursivoFinal(l,i+1,acu,a,l.get(a));                  
	        }
	        else
	        {
	            return res;
	        }
	    }
}
