package advstatmp2;

import java.util.ArrayList;
import java.util.List;

import math.Computations;


public class ADVSTATMP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Double> d = new ArrayList<Double>();
        Computations c = new Computations();
        
        
        d = c.parseExpression("1 2"); 	// x^2
        
        ArrayList<List<Double>> al = c.getSecant(d, 1, 10, .08d);
        
        for(List<Double> l : al){
        	for(Double dd : l)
        		System.out.println(dd);
        }
        
    }
}
