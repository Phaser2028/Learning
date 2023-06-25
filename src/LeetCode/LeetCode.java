package LeetCode;

import java.util.*;

public class LeetCode {


    //https://leetcode.com/problems/valid-parentheses
    public static boolean isValid(String s) {

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.empty();
    }





    //https://leetcode.com/problems/longest-common-prefix
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String low = strs[0];
        String high = strs[strs.length - 1];
        int i = 0;
        while (i < low.length()) {
            if (low.charAt(i) == high.charAt(i))
                i++;
            else
                break;
        }
        return i == 0 ? "" : low.substring(0, i);
    }

    //https://leetcode.com/problems/longest-common-prefix
    public static String longestCommonPrefixNaive(String[] strs) {

        StringBuilder lowestString = new StringBuilder(strs[0]);


        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }


        for (int i = 1; i < strs.length; i++) {
            if (lowestString.length() > strs[i].length()) {
                lowestString.delete(0, lowestString.toString().length());
                lowestString.append(strs[i]);
            }
        }
        int i = 0;
        String[] lowestStringToArr = lowestString.toString().split("");


        StringBuilder check = new StringBuilder(lowestStringToArr[i]);

        while (i < lowestString.length()) {

            for (String str : strs) {
                if (!str.startsWith(check.toString())) {
                    check.delete(check.length() - 1, check.length());
                    return check.toString();
                }
            }
            if (check.toString().equals(lowestString.toString())) {
                return check.toString();
            }
            if (i < lowestStringToArr.length - 1) {
                i++;
                check.append(lowestStringToArr[i]);
            } else {
                return lowestStringToArr[i];
            }
        }
        return check.toString();
    }


    //https://leetcode.com/problems/merge-strings-alternately
    public static String mergeAlternately(String word1, String word2) {

        StringBuilder res = new StringBuilder();

        byte pos1 = 0;
        byte pos2 = 0;

        while (pos1 < word1.length() || pos2 < word2.length()) {
            if (pos1 < word1.length()) {
                res.append(word1.charAt(pos1));
                pos1++;
            }
            if (pos2 < word2.length()) {
                res.append(word2.charAt(pos2));
                pos2++;
            }
        }

        return res.toString();

    }


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

        while (l1 != null || l2 != null || i != 0) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;

            int sum = i + a + b;

            i = sum / 10;


            node.next = new ListNode(sum % 10);
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
        return (((1 + nums.length) * nums.length) / 2) - Arrays.stream(nums).sum();
    }


    //https://leetcode.com/problems/contains-duplicate
    public boolean containsDuplicate(int[] nums) {
        return new HashSet<>(List.of(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size() != nums.length;
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

            if (i + 1 == s.length()) {
                res += dictionary.get(s.charAt(i));
                return res;
            }

            if (dictionary.get(s.charAt(i)) < dictionary.get(s.charAt(i + 1))) {
                res += (dictionary.get(s.charAt(i + 1)) - dictionary.get(s.charAt(i)));
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
