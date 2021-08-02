package objectoriented;

public class ExtendsDemo {
	public ExtendsDemo() {
		System.out.println("no arg constructor of ExtendsDemo");
	}
	
	public ExtendsDemo(int i) {
		System.out.println("arg constructor of ExtendsDemo, arg:" + i);
	}
	//û��ʵ����ExtendsDemo�������Բ������ExtendsDemo�Ĺ��췽��

	public static void main(String[] args) {
		new Class3(); // ������Ӳ��� Ĭ�ϵ���class3�������и�����޲ι���
		System.out.println();
		
		new Class3(1); // ������ϲ���������ò����б���ϵĹ��췽���͸�����޲ι��죨Ĭ�ϣ�

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
