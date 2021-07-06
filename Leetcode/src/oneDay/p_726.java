package oneDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p_726 {
	public static String countOfAtoms(String formula) {
        Stack stack = new Stack<>();
        List list = new ArrayList<>();
        for (int i = 0; i < formula.length(); i++) {
        	if (formula.charAt(i) == '(') {
        		i++;
        		while (formula.charAt(i) != ')') {
        			stack.push(formula.charAt(i));
        			i++;
        		}
        		i++;
        	}
        }
         
        return null;
    }
	
	public static void main(String[] args) {
		String formula = "K4(ON(SO3)2)2"; 
		System.out.println(countOfAtoms(formula));

	}

}
