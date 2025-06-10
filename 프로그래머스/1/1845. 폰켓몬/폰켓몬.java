import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int maxSelect = nums.length/2;
        long uniqueCount = Arrays.stream(nums).distinct().count();

        return (int)Math.min(uniqueCount, maxSelect);
    }
}