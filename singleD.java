import java.util.*;

class singleD {
    public static void main(String ar[]) {
        int arr[] = { 1, 2, 2, 3, 3 };
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++)
            {
                // System.out.println(num);
                num ^= nums[i];
            }
        return num;
    }
}