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
		s = s + "kve"; //�ᴴ����String���󣬴�ʱs�д洢�����¶���ĵ�ַ
		System.out.println(s);
		
		ss.append("vvv"); //ֱ����ԭ�����Ͻ����޸ģ����ı�ԭ����
		System.out.println(ss);
	}
}
