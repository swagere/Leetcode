package recursion;

//迷宫问题
//递归解决
//非bf
public class maze_1 {

	public static void main(String[] args) {
		//初始化地图
		//0为未走的路
		//1为墙
		//2为可以走的路
		//3为走不通的路
		int[][] map = new int[8][7];
		
		//设置墙
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[6][4] = 1;
		map[1][5] = 1;
		map[2][5] = 1;
		map[2][4] = 1;

		//显示
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//走迷宫
		recursion(map, 1, 1);
		
		//显示
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	//i j为目前开始的点
	//递归顺序：右 下 左 上
	private static boolean recursion(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			//如果走到终点，则返回
			return true;
		}
		else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if (recursion(map, i, j + 1)) { //右
					
					return true;
				}
				else if (recursion(map, i + 1, j)) { //下

					return true;
				}
				else if (recursion(map, i, j - 1)) { //左
	
					return true;
				}
				else if (recursion(map, i - 1, j)) { //上
	
					return true;
				}
				else {
					map[i][j] = 3;
					return false;
				}
			}
			else {
				return false;
			}
		}
	}

}
