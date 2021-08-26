package oneDay.leetcode;

import java.util.Arrays;

public class l_881 {
	public static int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
        int right = people.length - 1;
        int left = 0;
        int count = 0;
        while (left < right) {
        	if (people[left] + people[right] <= limit) {
        		right --;
        		left ++;
        		count ++;
        	}
        	else {
        		right --;
        		count ++;
        	}
        }
        
        if (right == left) {
        	count ++;
        }
        
        return count;
    }

	public static void main(String[] args) {
		int[] people = {};
		int limit = 3;
		System.out.println(numRescueBoats(people, limit));
	}

}
