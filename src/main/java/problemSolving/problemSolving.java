package problemSolving;

import java.util.HashMap;
import java.util.Map;

public class problemSolving {

    public static void main(String[] args) {

        int result=16;
        System.out.println(hasPairWithSum(result));

    }

    private static boolean hasPairWithSum(int result) {
        int[] a = {1, 2, 3, 5, 8, 9};
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i <= a.length - 1; i++) {
            int tar = result -a[i];
            if(nums.containsKey(tar))
                return true;
            else
                nums.put(a[i],a[i]);
        }
        return false;
    }
}
