package problemSolving;

import java.util.HashMap;
import java.util.Map;

public class problemSolving {

    public static void main(String[] args) {

        int rusult=16;
        System.out.println(hasPairWithSum(rusult));

    }

    private static boolean hasPairWithSum(int rusult) {
        int[] a = {1, 2, 3, 5, 8, 9};
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i <= a.length - 1; i++) {
            int tar = rusult -a[i];
            if(nums.containsKey(tar))
                return true;
            else
                nums.put(a[i],a[i]);
        }
        return false;
    }
}
