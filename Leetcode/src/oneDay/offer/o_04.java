package oneDay.offer;

public class o_04 {

	public static void main(String[] args) {
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 13;
		System.out.println(Solution042.findNumberIn2DArray(matrix, target));
	}

}

//先排除不可能的值
class Solution041 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
    	int n = matrix.length;
    	if (n == 0) {
    		return false;
    	}
    	int m = matrix[0].length;
    	int min = Math.min(n, m);
    	int index = 0;
    	for (int i = 0; i < min; i++) {
    		if (target > matrix[i][i]) {
    			continue;
    		}
    		else if (target == matrix[i][i]) {
    			return true;
    		}
    		else {
    			index = i;
    			break;
    		}
    	}
    	for (int i = index; i < n; i++) {
    		int j = 0;
    		for (j = 0; j < m; j++) {
    			if (matrix[i][j] < target) {
    				continue;
    			}
    			else if (matrix[i][j] == target) {
    				return true;
    			}
    			else {
    				break;
    			}
    		}
    		if (j == 0) {
    			break;
    		}
    	}
    	
    	for (int j = index; j < m; j++) {
    		int i = 0; 
    		for (i = 0; i < n; i++) {
    			if (matrix[i][j] < target) {
    				continue;
    			}
    			else if (matrix[i][j] == target) {
    				return true;
    			}
    			else {
    				break;
    			}
    		}
    		if (i == 0) {
    			break;
    		}
    	}
    	return false;
    }
}

//标志数+二叉搜索树
class Solution042 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
    	int n = matrix.length;
    	if (n == 0) {
    		return false;
    	}
    	int m = matrix[0].length;
    	for (int i = 0, j = m - 1; i < n && j >= 0;) {
    		if (matrix[i][j] > target) {
    			j -= 1;
    		}
    		else if (matrix[i][j] < target) {
    			i += 1;
    		}
    		else {
    			return true;
    		}
    	}
    	return false;
    }
}
