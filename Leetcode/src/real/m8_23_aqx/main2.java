package real.m8_23_aqx;

/**
 * 方格棋盘上，散落n颗珠子[n>3] ,珠子位置在横线与纵线的交叉点上。
 * 沿着盘上的格子线画线条，线条可以转弯，把珠子连起来，达到3颗即算成串。
 * 求最短的珠串长度。
 *
 */
public class main2 {
	public static int getMinLength (int[][] pearls) {
		int n = pearls.length;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					//计算距离
					int max_x = Math.max(Math.abs(pearls[i][0] - pearls[j][0]),  Math.abs(pearls[j][0] - pearls[k][0]));
					max_x = Math.max(Math.abs(pearls[i][0] - pearls[k][0]), max_x);
					
					int max_y = Math.max(Math.abs(pearls[i][1] - pearls[j][1]),  Math.abs(pearls[j][1] - pearls[k][1]));
					max_y = Math.max(Math.abs(pearls[i][1] - pearls[k][1]), max_y);
					
					int max_way = Math.max(Math.abs(pearls[i][0] - pearls[j][0]) + Math.abs(pearls[i][1] - pearls[j][1]), Math.abs(pearls[k][0] - pearls[j][0]) + Math.abs(pearls[k][1] - pearls[j][1]));
					max_way = Math.max(Math.abs(pearls[i][0] - pearls[k][0]) + Math.abs(pearls[i][1] - pearls[k][1]), max_way);

					int count = max_x * 2 + max_y * 2 - max_way;
					
					if (min > count) {
						min = count;
					}
				}
			}
		}
		return min;
    }

	public static void main(String[] args) {
		int[][] pearls = {
				{0,0},{0,2},{1,1},{10,10}
		};
		System.out.println(getMinLength(pearls));

	}

}
