package Day4;
import java.util.*;


class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List result = new ArrayList<>();
        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] > 0) {
                nums[n - 1] *= -1;
            } else {
                result.add(n);
            }
        }
        return result;
    }
}