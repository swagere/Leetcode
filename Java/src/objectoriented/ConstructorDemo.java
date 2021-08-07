package objectoriented;

public class ConstructorDemo {
	static void sout() {
		System.out.println("this is a static method");
	}
	static {
		System.out.println("this is static block");
	}
	
	{
		System.out.println("this is not static block");
	}
	
	public ConstructorDemo() {
		System.out.println("this is constructor");
	}

	public static void main(String[] args) {
		/**
		 *  ʵ��������
		 * this is static block
		 * this is not static block
		 * this is constructor
		 */
//		new ConstructorDemo();

		/**
		 * �������еľ�̬���� ��ʵ��������ʱ
		 * ���󲻻�����ʵ����
		 */
		ConstructorDemo.sout();

	}

}
