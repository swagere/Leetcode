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

//如果子类不能实现全部抽象方法 则子类必须为抽象类
abstract class class1 extends AbstractDemo {

	@Override
	public void abMethod() {
		// TODO Auto-generated method stub
		
	}
	
}

//直到子类实现全部抽象方法 此子类才可以不为抽象类
class class2 extends class1 {

	@Override
	public void absMethod() {
		// TODO Auto-generated method stub
		
	}
	
}
