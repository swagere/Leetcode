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
		new Clas3(); // ������Ӳ��� Ĭ�ϵ���class3�������и�����޲ι���
		System.out.println();
		
		new Clas3(1); // ������ϲ���������ò����б���ϵĹ��췽���͸�����޲ι��죨Ĭ�ϣ�

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
