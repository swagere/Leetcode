package study;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = in.nextLine();
        }
        List<String> l = new ArrayList();
        l.add(str[0]);
        
        for (int i = 1; i < n; i++) {
        	StringBuffer s = new StringBuffer(str[i]);
        	s.append(str[i]);
        	
        	//kmpÆ¥ÅäËã·¨
        	boolean flag = false;
        	for (int j = 0; j < l.size(); j++) {
        		int index = s.indexOf(l.get(j));
        		if (index != -1 && str[i].length() == l.get(j).length()) {
        			flag = true;
        			break;
        		}
        	}
        	if (flag == false) {
        		l.add(str[i]);
        	}
        }
        System.out.println(l.size());
    }
}