package dac;

public class Hanoitower {
	static int count = 0;

	public static void main(String[] args) {
		hanoitower(5, 'A', 'B', 'C');
		System.out.println(count);
	}
	
	public static void hanoitower(int num, char a, char b, char c) {
		count++;
		if (num == 1) {
			//用输出代表移动
			System.out.println("移动第" + num + "个:" + a + "->" + c);
		}
		else {
			//若大于等于1 则分成两个部分：最下面的一个+上面的所有
			//1. 移动上面的所有到B
			hanoitower(num - 1, a, c, b);
			
			//2. 移动最下面的一个
			System.out.println("移动第" + num + "个:" + a + "->" + c);
			
			//3. 移动上面的所有
			hanoitower(num - 1, b, a, c);
		}
	}

}
