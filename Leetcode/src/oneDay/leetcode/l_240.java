package oneDay.leetcode;

public class l_240 {
	public static boolean searchMatrix(int[][] matrix, int target) {
		boolean res = false;
		int i = 0;
		int j = 0;
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] < target) {
            	while (j + 1 < matrix[0].length) {
            		if (matrix[i][j + 1] < target) {
            			j += 1;
            		}
            		else {
            			break;
            		}
            	}
            	if (matrix[i][j] < target) {
            		i += 1;
            		j -= 1;
            	}
            	else {
            		i += 1;
            	}
            }
            else if (matrix[i][j] > target){
            	while (matrix[i][j] > target) {
            		
            	}
            }
            else {
            	res = true;
            	break;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
