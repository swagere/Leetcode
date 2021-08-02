package oneDay.leetcode;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;


//r
//朴素解法
//找到每队的军人数 再排序
public class l_1337_1 {

	public static int[] kWeakestRows(int[][] mat, int k) {
		int[] res = new int[k];
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
		
		for (int i = 0; i < mat.length; i++) {
			int j = 0;
			for (j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 0) {
					break;
				}
			}
			
			TreeSet<Integer> temp = map.getOrDefault(j, new TreeSet());
			temp.add(i);
			map.put(j, temp);
		}
		
		
		int index = 0;
		for (Integer i : map.keySet()) {
			for (int j = 0; j < map.get(i).size(); j++) {
				if (index == k) {
					break;
				}
				res[index] = (int) map.get(i).toArray()[j];
				index++;
				
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
		int k = 3;
		System.out.println(Arrays.toString(kWeakestRows(mat, k)));

	}

}
