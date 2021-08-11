package horseChess;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//��̤��������
//��������㷨
public class HorseChess {
	static int[][] chessBoard;
	static boolean finished;

	public static void main(String[] args) {
		int x = 6;
		int y = 6;
		int n = 5;
		int m = 3;
		
		chessBoard = new int[x][y];
		
		long t1 = System.currentTimeMillis();
		horseChess(n, m, 1);
		long t2 = System.currentTimeMillis();
		System.out.println("��ʱ��" + (t2 - t1));
		
		for (int[] item : chessBoard) {
			System.out.println(Arrays.toString(item));
		}
	}

	//��̤�����㷨 �����㷨
	private static void horseChess(int n, int m, int step) {
		chessBoard[n][m] = step;
		
		List<Point> nexts = getNexts(new Point(n, m));
		
		//�Ż�������̰�ģ�����һ���ܱ��������ٵĽڵ��ȱ���
//		sort(nexts);
		
		while (nexts.size() > 0) {
			Point temp = nexts.remove(0);
			if (chessBoard[temp.x][temp.y] == 0) {
				horseChess(temp.x, temp.y, step + 1);
			}
		}
		
		if (step < chessBoard.length * chessBoard.length && finished == false) {
			chessBoard[n][m] = 0;
		}
		else {
			finished = true;
			return;
		}
	}

	private static List<Point> getNexts(Point point) {
		//��õ�ǰ�����ߵ���һ����
		List<Point> res = new ArrayList<>();
		
		int x = point.x;
		int y = point.y;
		
		if (x - 2 >= 0) {
			//6 7
			if (y - 1 >= 0) {
				res.add(new Point(x - 2, y - 1));
			}
			if (y + 1 < chessBoard.length) {
				res.add(new Point(x - 2, y + 1));
			}
		}
		
		if (x + 2 < chessBoard.length) {
			// 3 2
			if (y - 1 >= 0) {
				res.add(new Point(x + 2, y - 1));
			}
			if (y + 1 < chessBoard.length) {
				res.add(new Point(x + 2, y + 1));
			}
		}
		
		if (y - 2 >= 0) {
			//5 4
			if (x - 1 >= 0) {
				res.add(new Point(x - 1, y - 2));
			}
			if (x + 1 < chessBoard.length) {
				res.add(new Point(x + 1, y - 2));
			}
		}
		
		if (y + 2 < chessBoard.length) {
			//0 1
			if (x - 1 >= 0) {
				res.add(new Point(x - 1, y + 2));
			}
			if (x + 1 < chessBoard.length) {
				res.add(new Point(x + 1, y + 2));
			}
		}
		
		return res;
	}
	
	public static void sort(List<Point> res){
		res.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				int c1 = getNexts(o1).size();
				int c2 = getNexts(o2).size();
				if (c1 < c2) {
					return -1;
				}
				else if (c1 == c2) {
					return 0;
				}
				return 1;
			}
		});
	}

}
