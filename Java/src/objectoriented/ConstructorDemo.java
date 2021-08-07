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
		 *  实例化对象
		 * this is static block
		 * this is not static block
		 * this is constructor
		 */
//		new ConstructorDemo();

		/**
		 * 调用类中的静态方法 不实例化对象时
		 * 对象不会主动实例化
		 */
		ConstructorDemo.sout();

	}

}
