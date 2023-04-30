package LeetCode;

public class LeetCode {


    //https://leetcode.com/problems/palindrome-number
    public static boolean isPalindrome(int x){
        String nums = String.valueOf(x);

        for (int i = 0; i < nums.length()/2; i++) {
            if(nums.charAt(i) !=nums.charAt(nums.length()-i-1)){
                return false;
            }
        }
        return true;
    }


    //https://leetcode.com/problems/two-sum
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }

        return new int[]{};
    }
}
