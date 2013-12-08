package math;

import java.util.ArrayList;
import java.util.List;



public class Computations {
    

	
	
    public ArrayList<List<Double>> getBisection(ArrayList<Double> polynomial, double x1, double x2, int iterations){
        ArrayList<List<Double>> al = new ArrayList<List<Double>>();		//FORMAT OF LIST : {x1, x2, x3, y3}
        double x3, y;
        
        for(int i = 0; i < iterations; i++){
        	al.add(new ArrayList<Double>());
        	x3 = (x1 + x2) / 2;
        	y = solvePolynomial(x3, polynomial);
        	al.get(i).add(x1);
        	al.get(i).add(x2);
        	al.get(i).add(x3); 	
        	if(y < 0)
        		x1 = x3;
        	else
        		x2 = x3;
        	
        }
        
        return al;
    }
    
    
    public ArrayList<List<Double>> getSecant(ArrayList<Double> polynomial, double x1, double x2, int iterations){
        ArrayList<List<Double>> al = new ArrayList<List<Double>>();		//FORMAT OF LIST : {x1, y1, x2, y2}
        double y1,y2,temp;
        
        for(int i = 0; i < iterations; i++){
        	al.add(new ArrayList<Double>());
        	y1 = solvePolynomial(x1, polynomial);
        	y2 = solvePolynomial(x2, polynomial);
        	al.get(i).add(x1);
        	al.get(i).add(y1);
        	al.get(i).add(x2);
        	al.get(i).add(y2);
        	
        	
        	temp = x1;
        	x1 = x2;
        	x2 = (temp * y2 - x2 * y1) / (y2 - y1);
        	
        }
        
        return al;
    }
    
    public ArrayList<List<Double>> getSecant(ArrayList<Double> polynomial, double x1, double x2, double tolerance){
        ArrayList<List<Double>> al = new ArrayList<List<Double>>();		//FORMAT OF LIST : {x1, y1, x2, y2}
        double y1,y2,temp;
        double error = 1d;
        int i = 0;
        while(error > tolerance){
        	al.add(new ArrayList<Double>());
        	y1 = solvePolynomial(x1, polynomial);
        	y2 = solvePolynomial(x2, polynomial);
        	al.get(i).add(x1);
        	al.get(i).add(y1);
        	al.get(i).add(x2);
        	al.get(i).add(y2);
        	
        	
        	temp = x1;
        	x1 = x2;
        	x2 = (temp * y2 - x2 * y1) / (y2 - y1);
        	error = Math.abs((x2 -  x1) / x2);
        	i++;
        }
        
        return al;
    }
    
    
    
    //solve for f(x)
    public Double solvePolynomial(double x, ArrayList<Double> polynomial){
        double y = 0;
        double z;
        
        for(int i = 0; i < polynomial.size(); i++){
            z = 0;
            
            if(i % 2 != 0){
                z += Math.pow(x, polynomial.get(i));
                z *= polynomial.get(i-1);
            }
        
            y += z;
        }
  
        return y;
    }
    
    public ArrayList<Double> parseExpression(String expression){
    	
    	ArrayList<Double> al = new ArrayList<Double>();
    	
    	String[] str = expression.split(" ");
    	int i = 0;
    	for(String s : str){
    		al.add(Double.parseDouble(str[i]));
    		i++;
    	}	
    	
    	return al;
    	
    }
    
}
