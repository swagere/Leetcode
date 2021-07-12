package oneDay.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//r
//从大到小
public class l_274_2 {

	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		System.out.println(hIndex(citations));
	}
	
	public static int hIndex(int[] citations) {
		List<Integer> list = Arrays.stream(citations).boxed().collect(Collectors.toList());
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {return o2 - o1;};
		});
		int i = 0;
		for (i = 0; i < list.size(); i++) {
			if (i + 1 > list.get(i)) {
				break;
			}
		}
		
		return i;
    }
}
