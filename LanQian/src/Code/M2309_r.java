package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M2309_r {
	static boolean isZimu(char a) {
		if (a - 'a' >= 0 && 'z' - a >= 0) {
			return true;
		}
		else if (a - 'A' >= 0 && 'Z' - a >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		in.nextLine();
		String s = in.nextLine();
		List<Integer> index_a = new ArrayList<Integer>();
		List<Integer> index_b = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A' && ( i == 0 || (i != 0 && !isZimu(s.charAt(i - 1))))) {
				i++;
				if (i < s.length() && s.charAt(i) == 'l') {
					i++;
					if (i < s.length() && s.charAt(i) == 'i') {
						i++;
						if (i < s.length() && s.charAt(i) == 'c') {
							i++;
							if (i < s.length() && s.charAt(i) == 'e') {
								i++;
								if (i < s.length() && !isZimu(s.charAt(i))) {
									index_a.add(i - 5);
								}
								else if (i == s.length()) {
									index_a.add(i - 5);
								}
							}
						}
						
					}
				}
			}
			else if (s.charAt(i) == 'B' && ( i == 0 || (i != 0 && !isZimu(s.charAt(i - 1))))) {
				i++;
				if (i < s.length() && s.charAt(i) == 'o') {
					i++;
					if (i < s.length() && s.charAt(i) == 'b') {
						i++;
						if (i < s.length() && !isZimu(s.charAt(i))) {
							index_b.add(i - 3);
						}
						else if (i == s.length()) {
							index_b.add(i - 3);
						}
					}
				}
			}
		}
		
		long count = 0;
		
		//遍历，找出符合条件的Bob的个数
        for(int i=0,l=0,r=-1;i<index_a.size();i++)
        {
            while((r+1<index_b.size())&&(index_a.get(i)>=index_b.get(r+1))) 
            {
                r++;
            }
            while((l<=r)&&index_a.get(i)-index_b.get(l)-2>k) 
            {
                l++;
            }
            count+=r-l+1;
        }
        //去找Bob前符合的Alice的数量
        for(int i=0,l=0,r=-1;i<index_b.size();i++)
        {
            while(r+1<index_a.size()&&index_b.get(i)>=index_a.get(r+1)) 
            {
                r++;
            }
            while((l<=r)&&index_b.get(i)-index_a.get(l)-4>k) 
            {
                l++;
            }
            if(l!=-1&&r!=-1)
            	count+=r-l+1;
        }
		System.out.println(count);
	}

}
