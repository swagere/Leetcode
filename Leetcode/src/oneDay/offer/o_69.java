package oneDay.offer;

public class o_69 {
	public static int peakIndexInMountainArray(int[] arr) {
        int i = 1;
        int j = arr.length - 1;
        while (i < j) {
            int mid = (i + j + 1) / 2;
            
            if (arr[mid] > arr[mid - 1]) {
                i = mid;
            }
            else {
            	j = mid - 1;
            }
        }
        return j;
    }

	public static void main(String[] args) {
		int[] arr = {
//				3,5,3,2,0
				0,1,0
//				24,69,100,99,79,78,67,36,26,19
		};
		System.out.println(peakIndexInMountainArray(arr));

	}

}
