package oneDay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//list
//int[][]

//r

public class p_1418 {
	public static List<List<String>> displayTable(List<List<String>> orders) {
        List<String> foots = new ArrayList<>();
        foots.add("Table");
        
        List<String> tables = new ArrayList<>();
        
        for (int i = 0; i < orders.size(); i++) {
            if (!foots.contains(orders.get(i).get(2))) {
            	for (int j = 1; j <= foots.size(); j++) {
            		if (j == foots.size() || orders.get(i).get(2).compareTo(foots.get(j)) < 0) {
            			foots.add(j, orders.get(i).get(2));
            			break;
            		}
            	}
            }
            
            if (!tables.contains(orders.get(i).get(1))) {
            	for (int j = 0; j <= tables.size(); j++) {
            		if (j == tables.size() || Integer.valueOf(orders.get(i).get(1)) < Integer.valueOf(tables.get(j))) {
            			tables.add(j, (orders.get(i).get(1)));
            			break;
            		}
            	}
            }
        }
        
        //计算结果
        int[][] res = new int[tables.size()][foots.size()];
        for (int i = 0; i < orders.size(); i++) {
        	for (int j = 0; j < tables.size(); j++) {
        		res[j][0] = Integer.valueOf(tables.get(j));
        	}
        	res[tables.indexOf(orders.get(i).get(1))][foots.indexOf(orders.get(i).get(2))]++;
        }

        //打印res
//        for (int j = 0; j < tables.size(); j++) {
//    		for (int k = 0; k < foots.size(); k++) {
//        		System.out.print(res[j][k] + " ");
//        	}
//        	System.out.println();
//        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        result.add(foots);
        
        for (int i = 0; i < tables.size(); i++) {
        	result.add(Arrays.stream(res[i]).boxed().map(String::valueOf).collect(Collectors.toList()));
        }
        
        return result;
    }

	public static void main(String[] args) {
		List<List<String>> orders = Arrays.asList(Arrays.asList("David","3","Ceviche"),Arrays.asList("Corina","10","Beef Burrito"),Arrays.asList("David","3","Fried Chicken"),Arrays.asList("Carla","5","Water"),Arrays.asList("Carla","5","Ceviche"),Arrays.asList("Rous","3","Ceviche"));

		System.out.println(displayTable(orders));

	}

}
