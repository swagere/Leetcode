package objectoriented;

public abstract class AbstractDemo {
	int i = 1;
	
	public void defult() {
		System.out.println("this is a public method");
	}
	
	public abstract void abMethod();
	
	public abstract void absMethod();
	
	public AbstractDemo() {
		System.out.println("this is a constructor method");
	}
	
	public static void main(String[] args) {
		new class2();
	}
}

//������಻��ʵ��ȫ�����󷽷� ���������Ϊ������
abstract class class1 extends AbstractDemo {

	@Override
	public void abMethod() {
		// TODO Auto-generated method stub
		
	}
	
}

//ֱ������ʵ��ȫ�����󷽷� ������ſ��Բ�Ϊ������
class class2 extends class1 {

	@Override
	public void absMethod() {
		// TODO Auto-generated method stub
		
	}
	
}
