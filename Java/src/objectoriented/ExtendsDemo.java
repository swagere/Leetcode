package objectoriented;

public class ExtendsDemo {
	public ExtendsDemo() {
		System.out.println("no arg constructor of ExtendsDemo");
	}
	
	public ExtendsDemo(int i) {
		System.out.println("arg constructor of ExtendsDemo, arg:" + i);
	}
	//没有实例化ExtendsDemo对象，所以不会调用ExtendsDemo的构造方法

	public static void main(String[] args) {
		new Class3(); // 如果不加参数 默认调用class3和其所有父类的无参构造
		System.out.println();
		
		new Class3(1); // 如果加上参数，则调用参数列表符合的构造方法和父类的无参构造（默认）

	}

}

class Class1 {
	public Class1() {
		System.out.println("no arg constructor of Class1");
	}
	
	public Class1(int i) {
		System.out.println("arg constructor of Class1, arg:" + i);
	}
}

class Class2 extends Class1 {
	public Class2() {
		System.out.println("no arg constructor of Class2");
	}
	
	public Class2(int i) {
		System.out.println("arg constructor of Class2, arg:" + i);
	}
}

class Class3 extends Class2 {
	public Class3() {
		this(1);
		System.out.println("no arg constructor of Class3");
	}
	
	public Class3(int i) {
		super(3);
		System.out.println("arg constructor of Class3, arg:" + i);
	}
}
