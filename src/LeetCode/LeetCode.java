package LeetCode;

import java.util.*;

public class LeetCode {

    //https://leetcode.com/problems/maximum-average-subarray-i
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for(int i = 0; i < k; i ++)
            sum += nums[i];

        int maxSum = sum;

        for(int i = k; i < nums.length; i ++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }

    //https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int a = i+1, b = nums.length - 1;


            while (a<b) {
                int sum = nums[i]+nums[a] + nums[b];
                if (sum< 0)
                    a++;
                else if (sum > 0)
                    b--;
                else {
                    set.add(List.of(nums[i], nums[a], nums[b]));
                    a++;
                    b--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    //https://leetcode.com/problems/3sum/
    public static List<List<Integer>> threeSumNotEffective(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int a = i+1, b = nums.length - 1;

            while (a<b) {
                if (cur + nums[a] + nums[b] < 0)
                    a++;
                else if (cur + nums[a] + nums[b] > 0)
                    b--;
                else {
                    set.add(List.of(cur, nums[a], nums[b]));
                    a++;
                    b--;
                }
            }
        }

        return new ArrayList<>(set);
    }


    //https://leetcode.com/problems/max-number-of-k-sum-pairs
    public static int maxOperationsEffective(int[] nums, int k) {
        Arrays.sort(nums);

        int a = 0, b = nums.length - 1;
        int count = 0;


        while (a<b){
            if(nums[a]+nums[b]<k){
                a++;
            }else if(nums[a]+nums[b]>k) {
                b--;
            }else {
                a++;
                b--;
                count++;
            }
        }

        return count;
    }

    //https://leetcode.com/problems/max-number-of-k-sum-pairs
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int a = 0, b = nums.length - 1;
        int count = 0;


        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        while (a<b){
            if(map.get(a)+map.get(b)<k){
                a++;
            }else if(map.get(a)+map.get(b)>k) {
                b--;
            }else {
                map.remove(a);
                map.remove(b);
                a++;
                b--;
                count++;
            }
        }

        return count;
    }

    //https://leetcode.com/problems/container-with-most-water
    public static int maxArea(int[] height) {
        int a = 0, b = height.length - 1;
//        int S = (b - a) * Math.min(height[a], height[b]);
        int S;
        int S_MAX = Integer.MIN_VALUE;

        while (a<b){
            S = (b - a) * Math.min(height[a], height[b]);
            if(S_MAX<S){
                S_MAX = S;
            }
            if(height[a] < height[b]){
                a++;
            } else if (height[a] >= height[b]) {
                b--;
            }

        }
        return S_MAX;

    }

    //https://leetcode.com/problems/is-subsequence
    public static boolean isSubsequence(String s, String t) {

        int i = 0 , j = 0;

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }


    //https://leetcode.com/problems/move-zeroes
    public static void moveZeroes(int[] nums) {
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[n] = nums[i];
                n++;
            }
        }
        while(n<nums.length){
            nums[n] = 0;
            n++;
        }
    }

    //https://leetcode.com/problems/two-sum
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i],i);
            }else {
                return new int[]{map.get(target - nums[i]),i};
            }
        }
        return new int[]{};
    }


    //https://leetcode.com/problems/increasing-triplet-subsequence
    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            } else if (num > min && num < mid) {
                mid = num;
            } else if (num > mid) {
                return true;
            }
        }
        return  false;
    }

    //https://leetcode.com/problems/reverse-words-in-a-string
    public static String reverseWords(String s) {

        String[] words = s.trim().replaceAll("\\s+", " ").split(" ");

        String temp;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < (words.length) / 2; i++) {
            temp = words[i];
            words[i] = words[words.length-1-i];
            words[words.length - i - 1] = temp;
        }

        for (String i :
                words) {
            res.append(i+" ");
        }
        return res.toString().trim();
    }

    //https://leetcode.com/problems/reverse-vowels-of-a-string
    public static String reverseVowels(String s) {
        char[] letters = s.toCharArray();
        int l = 0;
        int r = letters.length - 1;
        char temp;

        boolean leftCheck;
        boolean rightCheck;


        while (l <= r) {

            leftCheck = letters[l] == 'a' || letters[l] == 'e' || letters[l] == 'i' ||
                    letters[l] == 'o' || letters[l] == 'u' ||
                    letters[l] == 'A' || letters[l] == 'E' || letters[l] == 'I' ||
                    letters[l] == 'O' || letters[l] == 'U';


            rightCheck = letters[r] == 'a' || letters[r] == 'e' || letters[r] == 'i' ||
                    letters[r] == 'o' || letters[r] == 'u' ||
                    letters[r] == 'A' || letters[r] == 'E' || letters[r] == 'I' ||
                    letters[r] == 'O' || letters[r] == 'U';

            if (leftCheck && rightCheck) {

                temp = letters[l];

                letters[l] = letters[r];
                letters[r] = temp;

                r--;
                l++;

            } else if (!leftCheck && rightCheck) {
                l++;
            } else if (leftCheck && !rightCheck) {
                r--;
            } else if (!leftCheck && !rightCheck) {
                r--;
                l++;
            }
        }
        return new String(letters);
    }

    //https://leetcode.com/problems/can-place-flowers
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;

        int l = 0;
        int r = 0;

        for (int i = 0; i < flowerbed.length; i++) {


            if (i==0&&flowerbed.length>1) {
                l = 0;
                r = flowerbed[i + 1];
            }
            else if (flowerbed.length>1&&i == flowerbed.length - 1) {

                r = 0;
                l = flowerbed[i - 1];

            } else if(flowerbed.length>2) {
                l = flowerbed[i - 1];
                r = flowerbed[i + 1];
            }

            if (flowerbed[i] == 0 && l==0 && r==0) {
                flowerbed[i] = 1;
                count++;
            }


        }
        return count >= n;

    }

    //https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);

        byte max = Byte.MIN_VALUE;

        for (int candy : candies) {
            max = (byte) Math.max(max, candy);
        }
        for (int candy : candies) {
            res.add((candy + extraCandies) >= max);
        }
        return res;
    }

    //https://leetcode.com/problems/greatest-common-divisor-of-strings
    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1))
            return "";

        int a = Math.max(str1.length(),str2.length());
        int b = Math.min(str1.length(),str2.length());

        int r = a % b;

        while (r>0){
            a = b;
            b = r;
            r = a % b;
        }
        return str1.substring(0,b);

    }



    //https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
    public static int countOdds(int low, int high) {
        return (high - low + 1) % 2 == 0 ?
                (high - low + 1) / 2 : high % 2 == 0 & low % 2 == 0 ?
                (high - low) / 2 : 1 + (high - low) / 2;
    }

    //https://leetcode.com/problems/climbing-stairs
    public static int climbStairs(int n) {

        int[] steps = new int[2];

        steps[0] = 1;
        steps[1] = 2;

        for (int i = 2; i < n; i++) {
            steps[i%2] = steps[0]+steps[1];
        }
        return steps[(n-1)%2];
    }

    //https://leetcode.com/problems/single-number
    public static int singleNumber(int[] nums) {//XOR
        short mask = 0;
        for (int i = 0; i < nums.length; i++)
            mask ^= nums[i];

        return mask;
    }

    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
    public static List<Integer> findDisappearedNumbers(int[] nums) {//cyclic-sort
        List<Integer> res = new ArrayList<>();

        int n = 0; //10^5
        while (n < nums.length-1) {
            int pos = nums[n] - 1;

            if (nums[n] != nums[pos]) {
                int cur =  nums[n];
                nums[n] = nums[pos];
                nums[pos] = cur;
            }
            else {
                n++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        System.gc();
        return res;
    }


    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public static int[] twoSumII(int[] numbers, int target) {
        short l = 0;
        short r = (short) (numbers.length-1);

        while (l < r) {

            if (numbers[l] + numbers[r] > target)
                r--;
            else if (numbers[l] + numbers[r] < target) {

                l++;
            } else {
                System.gc();
                return new int[]{l+1,r+1};
            }
        }
        System.gc();
        return new int[]{};
    }

    //https://leetcode.com/problems/longest-consecutive-sequence
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new TreeSet<>();
        int longestLength = 1;
        int length = 1;

        for (Integer i : nums)
            set.add(i);

        for (int cur : set) {
            if (set.contains(cur + 1)) {
                length++;
                if (length > longestLength) {
                    longestLength = length;
                }
            } else {
                length = 1;
            }
        }

        return longestLength;
    }
    //https://leetcode.com/problems/valid-sudoku
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> box = new HashMap<>();


        for (int i = 0; i < 9; i++) {
            if (!row.containsKey(i)) {
                row.put(i, new HashSet<>());
            }
            if (!col.containsKey(i)) {
                col.put(i, new HashSet<>());
            }
            if (!box.containsKey(i)) {
                box.put(i, new HashSet<>());
            }
        }


        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (row.get(i).contains(board[i][j])) {
                    return false;
                }
                if (col.get(i).contains(board[i][j])) {
                    return false;
                }

                row.get(i).add(board[i][j]);
                col.get(i).add(board[i][j]);

            }
        }


        return true;

    }

    //https://leetcode.com/problems/valid-palindrome
    public static boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^A-Za-zР-пр-џ0-9]", "").toLowerCase();
        System.out.println(s1);
        StringBuilder stringBuilder = new StringBuilder(s1);

        return stringBuilder.reverse().toString().equals(s1);
    }


    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    public static int maxProfit(int[] prices) {
        //7, 1, 5, 3, 6, 4
        //1, 2, 3, 4, 5, 6

        int l = 0;
        int r = 0;
        int profit = 0;
        int max = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                profit = prices[r] - prices[l];
                if (max < profit) {
                    max = profit;
                } else {
                    r++;
                }
            } else {
                l = r;
                r++;
            }

        }
        return max;
    }

    //https://leetcode.com/problems/binary-search
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    //https://leetcode.com/problems/product-of-array-except-self
    public static int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] res = new int[l];
//
//        int[] prefix = new int[l];
//        int[] postfix = new int[l];

        int pr = 1;
        for (int i = 0; i < l; i++) {
            res[i] = pr;
            pr = pr * nums[i];
        }

        int ps = 1;
        for (int i = l - 1; i > -1; i--) {

            res[i] = ps * res[i];
            ps = ps * nums[i];
        }

        return res;
    }


    //https://leetcode.com/problems/top-k-frequent-elements
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] res = new int[k];

        for (Integer i :
                nums) {

            if (!map.containsKey(i))
                map.put(i, new ArrayList<>());
            map.get(i).add(i);
        }

        int i = 0;
        while (i < k) {
            int maxLength = 0;
            Integer longestKey = null;
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                int length = entry.getValue().size();
                if (length > maxLength) {
                    maxLength = length;
                    longestKey = entry.getKey();
                }
            }

            res[i] = longestKey;
            map.remove(longestKey);
            i++;
        }

        return res;
    }


    //https://leetcode.com/problems/group-anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {


        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = new String(c);

            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());

            map.get(keyStr).add(s);
        }


        List<List<String>> res = new LinkedList<>(map.values());
        return res;
    }


    //https://leetcode.com/problems/valid-anagram/
    public static boolean isAnagram(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.equals(first, second);
    }

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
    public int[] twoSumNaive(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return new int[]{};
    }
}
