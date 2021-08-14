package oneDay.leetcode;

//r
//模拟
public class l_1583 {
	public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        if (n == 2) {
            return 0;
        }

        //先处理preference
        int[][] pre = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                pre[i][preferences[i][j]] = n - j;
            }
            
        }
        
//        for (int i = 0; i < preferences.length; i++) {
//            System.out.println(Arrays.toString(pre[i]));       
//        }

        int index = 0;
        for (int i = 0; i < pairs.length; i++) {
            int j0 = pairs[i][0];
            int j1 = pairs[i][1];
            boolean c0 = false;
            boolean c1 = false;
            for (int k = 0; k < pairs.length; k++) {
        		if (c0 == false && pre[j0][pairs[k][0]] > pre[j0][j1] && pre[pairs[k][0]][j0] > pre[pairs[k][0]][pairs[k][1]]) {
	        		index++;
	        		c0 = true;
	        	}
        		else if (c0 == false && pre[j0][pairs[k][1]] > pre[j0][j1] && pre[pairs[k][1]][j0] > pre[pairs[k][1]][pairs[k][0]]) {
	        		index++;
	        		c0 = true;
	        	}
                    	
	        	if (c1 == false && pre[j1][pairs[k][0]] > pre[j1][j0] && pre[pairs[k][0]][j1] > pre[pairs[k][0]][pairs[k][1]]) {
	        		index++;
	        		c1 = true;
            	}
	        	else if (c1 == false && pre[j1][pairs[k][1]] > pre[j1][j0] && pre[pairs[k][1]][j1] > pre[pairs[k][1]][pairs[k][0]]) {
	        		index++;
	        		c1 = true;
            	}
	        	
	        	if (c1 == true && c0 == true) {
	        		break;
	        	}
	        }
        }

        return index;
    }

	public static void main(String[] args) {
		int n = 4;
		int[][] preferences = {
//				{1,2,3},{3,2,0},{3,1,0},{1,2,0}
//				{1},{0}
				{1,3,2},{2,3,0},{1,3,0},{0,2,1}
		};
		int[][] pairs = {
//				{0,1},{2,3}
//				{1,0}
				{1,3},{0,2}
		};

		System.out.println(unhappyFriends(n, preferences, pairs));
	}

}
