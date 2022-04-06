package oneDay.leetcode;

import java.util.Arrays;

public class l_200 {

	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'},
		};
		System.out.println(new Solution2001().numIslands(grid));
	}

}

class Solution2001 {
    public int numIslands(char[][] grid) {
    	if (grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	
    	int count = 0;
    	int[][] v = new int[grid.length][grid[0].length];
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (v[i][j] == 0 && grid[i][j] == '1') {
    				visit(grid, v, i, j);
    				count += 1;
    			}
    		}
    	}
    	
    	return count;
    	
    }
    
    public void visit(char[][] grid, int[][] v, int a, int b) {
    	if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length || grid[a][b] == '0' || v[a][b] == 1) {
    		return;
    	}
    	
    	v[a][b] = 1;
    	visit(grid, v, a + 1, b);
    	visit(grid, v, a - 1, b);
    	visit(grid, v, a, b + 1);
    	visit(grid, v, a, b - 1);
    	
    }
    
    public void print(int[][] v) {
    	for (int i = 0; i < v.length; i++) {
    		System.out.println(Arrays.toString(v[i]));
    	}
    }
}
