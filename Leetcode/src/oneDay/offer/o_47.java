package oneDay.offer;

import java.util.ArrayList;
import java.util.List;

public class o_47 {

	public static void main(String[] args) {
		int[][] grid = {
				{7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5},
				{9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6},
				{8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8},
				{6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4},
				{7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4},
				{9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9},
				{1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4},
				{3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2},
				{1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3},
				{5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7},
				{2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7},
				{0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9}
		};
		System.out.println(Solution474.maxValue(grid));

	}

}
//动态规划 + 广度优先搜索
class Solution471 {
    public static int maxValue(int[][] grid) {
    	int x = grid.length;
    	if (x == 0) {
    		return 0;
    	}
    	int y = grid[0].length;
    	N first = new N(0, 0);
    	List<N> list = new ArrayList<>();
    	list.add(first);
    	int[][] res = new int[x][y];
    	res[0][0] = grid[0][0];
    	while (list.size() > 0) {
    		List<N> t = list;
    		list = new ArrayList<>();
    		while (t.size() > 0) {
    			N temp = t.remove(0);
    			int right = temp.getRight();
    			int down = temp.getDown();
    			if (down + 1 < y) {
    				res[right][down + 1] = Math.max(res[right][down + 1], res[right][down] + grid[right][down + 1]);
					list.add(new N(right, down + 1));
    			}
    			if (right + 1 < x) {
    				res[right + 1][down] = Math.max(res[right + 1][down], res[right][down] + grid[right + 1][down]);
    				if (down == 0) {
    					list.add(new N(right + 1, down));
    				}
    			}
    		}
    	}
    	return res[x - 1][y - 1];
    }
}

class N {
	private int right;
	private int down;
	
	public N(int right, int down) {
		this.right = right;
		this.down = down;
	}

	public int getRight() {
		return right;
	}

	public int getDown() {
		return down;
	}
}

//优化：动态规划 + 广度优先搜索 类改为int[]
class Solution472 {
  public static int maxValue(int[][] grid) {
  	int x = grid.length;
  	if (x == 0) {
  		return 0;
  	}
  	int y = grid[0].length;
  	List<int[]> list = new ArrayList<>(); //int[]代替类
  	list.add(new int[]{0,0});
  	int[][] res = new int[x][y];
  	res[0][0] = grid[0][0];
  	while (list.size() > 0) {
  		List<int[]> t = list;
  		list = new ArrayList<>();
  		while (t.size() > 0) {
  			int[] temp = t.remove(0);
  			int right = temp[0];
  			int down = temp[1];
  			if (down + 1 < y) {
  				res[right][down + 1] = Math.max(res[right][down + 1], res[right][down] + grid[right][down + 1]);
  				list.add(new int[] {right, down + 1});
  			}
  			if (right + 1 < x) {
  				res[right + 1][down] = Math.max(res[right + 1][down], res[right][down] + grid[right + 1][down]);
  				if (down == 0) list.add(new int[] {right + 1, down});
  			}
  		}
  	}
  	return res[x - 1][y - 1];
  }
}

//优化优化：动态规划
class Solution473 {
    public static int maxValue(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (i == 0 && j == 0) {
    				continue;
    			}
    			else if (i == 0) {
    				grid[i][j] = grid[i][j - 1] + grid[i][j];
    			}
    			else if (j == 0) {
    				grid[i][j] = grid[i - 1][j] + grid[i][j];
    			}
    			else {
    				grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
    			}
    		}
    	}
    	return grid[m - 1][n - 1];
    }
}

//优化优化优化：动态规划
class Solution474 {
  public static int maxValue(int[][] grid) {
  	int m = grid.length;
  	int n = grid[0].length;
  	for (int j = 1; j < n; j++) {
  		grid[0][j] = grid[0][j - 1] + grid[0][j];
  	}
  	for (int i = 1; i < m; i++) {
  		grid[i][0] = grid[i - 1][0] + grid[i][0];
  	}
  	for (int i = 1; i < m; i++) {
  		for (int j = 1; j < n; j++) {
			grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
  		}
  	}
  	return grid[m - 1][n - 1];
  }
}