import java.util.*;

public class RP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5, 4, 3, 2, 1};
		System.out.println(reversePairs(nums));
	}

	public static int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int r = 0;
        Map<Integer, Integer> index = new HashMap<>();
        Integer[] nobjs = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Integer x = new Integer(nums[i]);
            index.put(i, x);
            nobjs[i] = x;
        }
        Arrays.sort(nobjs);
        for (Integer n : nobjs) System.out.print(n + " ");
        System.out.println();
        int upper = Arrays.binarySearch(nobjs, nobjs[nobjs.length - 1] / 2);
        if (upper < 0) {
        	upper = -upper - 1;
        }
        for (int i = 0; i <= upper; i++) {
            int y = nobjs[i] * 2;
            int j = Arrays.binarySearch(nobjs, y);
            if (j < 0) {
            	j = -j - 1;
            }
            System.out.println("y=" + y + ",j=" + j);
            for (int x = i; x <= j; x++) {
            	if (index.get(nobjs[x]) > index.get(nobjs[j])) {
            		System.out.println(nobjs[x] + "," + nobjs[j]);
            		r++;
            	}
            }
        }
        return r;
    }
}
