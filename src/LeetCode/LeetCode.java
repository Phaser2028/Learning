package LeetCode;

import java.util.*;

public class LeetCode {


    //https://leetcode.com/problems/add-two-numbers

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode node = result;

        int i = 0;

        while(l1!=null||l2!=null||i!=0){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = i + a + b;

            i = sum / 10;


            node.next = new ListNode(sum%10);
            node = node.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }

        return result.next;

    }








    //https://leetcode.com/problems/missing-number
    public int missingNumber(int[] nums) {
        //S = (a(1) + a(n)) * n / 2
        return (((1+nums.length)*nums.length)/2) - Arrays.stream(nums).sum();
    }



    //https://leetcode.com/problems/contains-duplicate
    public boolean containsDuplicate(int[] nums) {
        return new HashSet<>(List.of(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size()!=nums.length;
    }


    //https://leetcode.com/problems/roman-to-integer
    public static int romanToInt(String s) {

        Map<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);

        int res = 0;

        for (int i = 0; i < s.length(); i++) {

            if(i+1==s.length()){
                res += dictionary.get(s.charAt(i));
                return res;
            }

            if (dictionary.get(s.charAt(i)) < dictionary.get(s.charAt(i+1))) {
                res += (dictionary.get(s.charAt(i+1)) - dictionary.get(s.charAt(i)));
                i++;
            } else {
                res += dictionary.get(s.charAt(i));
            }
        }
        return res;
    }


    //https://leetcode.com/problems/palindrome-number
    public static boolean isPalindrome(int x) {
        String nums = String.valueOf(x);

        for (int i = 0; i < nums.length() / 2; i++) {
            if (nums.charAt(i) != nums.charAt(nums.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    //https://leetcode.com/problems/two-sum
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{};
    }
}
