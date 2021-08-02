package oneDay.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

//r
//∂—≈≈–Ú
public class l_1337_3 {

	public static int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
			if (a[0] != b[0]) return b[0] - a[0];
			return b[1] - a[1];
		});
		for (int i = 0; i < mat.length; i++) {
			int l = 0;
			int r = mat[0].length - 1;
			int mid = 0;
			while (l <= r) {
				mid = (l + r) / 2;
				if (mat[i][mid] >= 1) {
					l = mid + 1;
				}
				else {
					r = mid - 1;
				}
			}
			
			if(q.size() == k) {
				if (q.peek()[0] > l) {
					System.out.println(0);
					q.poll();
				}
                else if (q.peek()[0] == l) {
                    if (q.peek()[1] > i) {
                    	System.out.println(1);
                        q.poll();
                    }
                }
			}
            if (q.size() < k) {
                q.add(new int[] {l, i});
            }
		}
		
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = q.poll()[1];
		}
		
		
		return res;
    }
	
	public static void main(String[] args) {
		int[][] mat = {{1,1,1,1,1,1},{1,1,1,0,0,0},{1,1,0,0,0,0}};
		int k = 2;
		System.out.println(Arrays.toString(kWeakestRows(mat, k)));

	}

}
