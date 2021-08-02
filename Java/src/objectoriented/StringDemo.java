package objectoriented;
public class StringDemo {

	public static void main(String[] args) {
		String s = "hello";
		StringBuffer ss = new StringBuffer("kkk");
		fun(s, ss);
		System.out.println(s);
		System.out.println(ss);
	}

	public static void fun(String s, StringBuffer ss) {
		s = s + "kve"; //会创建新String对象，此时s中存储的是新对象的地址
		System.out.println(s);
		
		ss.append("vvv"); //直接在原对象上进行修改，不改变原对象
		System.out.println(ss);
	}
}
