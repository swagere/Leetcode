package real.m4_17_hl;
import java.util.*;


public class Solution1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(new Solution1().findKth(arr, 5));
	}
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param arr int整型一维数组 数组
     * @param k int整型 k
     * @return int整型
     */
    public int findKth (int[] arr, int k) {
    	int len = arr.length;
        //堆排序插入
    	for (int i = 1; i < len; i++) {
    		int temp = i;
    		while ((temp - 1) / 2 >= 0) {
    			if (arr[(temp - 1) / 2] < arr[temp]) {
    				swap(arr, (temp - 1) / 2, temp); 
    				temp = (temp - 1) / 2;
    			} else {
    				break;
    			}
    		}
    	}
    	
    	//堆排序读出
    	for (int i = 0; i < len; i++) {
    		if (k == i + 1) {
    			return arr[0];
    		}
    		
    		swap(arr, 0, len - 1 - i);
    		
    		//堆排序下沉
    		int temp = 0;
    		while (temp * 2 + 1 < len - 1 - i || temp * 2 + 2 < len - 1 - i) {
				if (temp * 2 + 1 < len - 1 - i && temp * 2 + 2 < len - 1 - i) {
					if (arr[temp * 2 + 1] > arr[temp * 2 + 2]) {
						if (arr[temp * 2 + 1] > arr[temp]) {
							swap(arr, temp, temp * 2 + 1);
							temp = temp * 2 + 1;
						} else {
							break;
						}
						
					}
					else {
						if (arr[temp * 2 + 2] > arr[temp]) {
							swap(arr, temp, temp * 2 + 2);
							temp = temp * 2 + 2;
						} else {
							break;
						}
					}
    			}
				else if (temp * 2 + 1 < len - 1 - i) {
					if (arr[temp * 2 + 1] > arr[temp]) {
						swap(arr, temp, temp * 2 + 1);
						temp = temp * 2 + 1;
					} else {
						break;
					}
				}
				else if (temp * 2 + 2 < len - 1 - i){
					if (arr[temp * 2 + 2] > arr[temp]) {
						swap(arr, temp, temp * 2 + 2);
						temp = temp * 2 + 2;
					} else {
						break;
					}
				}
				else {
					break;
				}
    		}
    	}
    	return -1;
    }
    
    public void swap(int[] arr, int a, int b) {
    	int temp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = temp;
    }
}