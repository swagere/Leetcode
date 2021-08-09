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
		new Clas3(); // 如果不加参数 默认调用class3和其所有父类的无参构造
		System.out.println();
		
		new Clas3(1); // 如果加上参数，则调用参数列表符合的构造方法和父类的无参构造（默认）

	}

}

class Clas1 {
	public Clas1() {
		System.out.println("no arg constructor of Clas1");
	}
	
	public Clas1(int i) {
		System.out.println("arg constructor of Clas1, arg:" + i);
	}
}

class Clas2 extends Clas1 {
	public Clas2() {
		System.out.println("no arg constructor of Clas2");
	}
	
	public Clas2(int i) {
		System.out.println("arg constructor of Clas2, arg:" + i);
	}
}

class Clas3 extends Clas2 {
	public Clas3() {
		this(1);
		System.out.println("no arg constructor of Clas3");
	}
	
	public Clas3(int i) {
		super(3);
		System.out.println("arg constructor of Clas3, arg:" + i);
	}
}
