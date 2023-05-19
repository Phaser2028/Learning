package HackerRank;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solution {

    //https://www.hackerrank.com/challenges/simple-addition-varargs
    static class  Add {
        public void add(int... nums) {
            int sum=0;
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                sum += nums[i];
                if(i!=nums.length-1)
                    System.out.print("+");
            }
            System.out.print("=");
            System.out.println(sum);
        }
    }

    //https://www.hackerrank.com/challenges/java-factory
//    interface Food {
//        public String getType();
//    }
//
//    class Pizza implements Food {
//        public String getType() {
//            return "Someone ordered a Fast Food!";
//        }
//    }
//
//    class Cake implements Food {
//        public String getType() {
//            return "Someone ordered a Dessert!";
//        }
//    }
//
//    class FoodFactory {
//        public Food getFood(String order) {
//            if (order.equals("cake"))
//                return new Cake();
//            return new Pizza();
//        }


        //https://www.hackerrank.com/challenges/java-reflection-attributes
//    public static void main(String[] args){
//        Class student = Main.Student.class;
//        Method[] methods = student.getDeclaredMethods();
//
//        ArrayList<String> methodList = new ArrayList<>();
//        for (int i = 0; i < methods.length; i++) {
//            methodList.add(methods[i].getName());
//        }
//        Collections.sort(methodList);
//        for(String name: methodList){
//            System.out.println(name);
//        }
//
//    }

        //https://www.hackerrank.com/challenges/java-lambda-expressions
        public void lambdaExpressions() {
            Scanner in = new Scanner(System.in);
            int q = in.nextInt();
            while (q-- > 0) {
                int func = in.nextInt();
                int arg = in.nextInt();
                switch (func) {
                    case 1:
                        System.out.println(arg % 2 == 0 ? "EVEN" : "ODD");
                        break;
                    case 2:
                        int c = 0;
                        int d = 2;
                        while (d < arg) {
                            if (arg % d == 0) {
                                c++;
                            }
                            d++;
                        }
                        boolean isPrime = c <= 0;

                        System.out.println(isPrime ? "PRIME" : "COMPOSITE");
                        break;
                    case 3:
                        String reversed = new StringBuilder(String.valueOf(arg)).reverse().toString();
                        System.out.println(String.valueOf(arg).equals(reversed) ? "PALINDROME" : "NOT PALINDROME");
                        break;
                }
            }
        }


        //https://www.hackerrank.com/challenges/java-exception-handling-try-catch
        public void exceptionHandler() {
            Scanner in = new Scanner(System.in);
            try {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(a / b);
            } catch (InputMismatchException exception) {
                System.out.println("java.util.InputMismatchException");
            } catch (ArithmeticException exception) {
                System.out.println("java.lang.ArithmeticException: / by zero");
            }
        }

        //https://www.hackerrank.com/challenges/java-singleton
//    class Singleton{
//        public String str;
//        private Singleton(){}
//        public static Singleton instance;
//
//        static Singleton getSingleInstance(){
//            if (instance == null) {
//                instance = new Singleton();
//            }
//            return instance;
//        }
//    }


        //https://www.hackerrank.com/challenges/java-bitset
        public static void bitOperations() {
            Scanner in = new Scanner(System.in);

            int n = in.nextInt();
            int m = in.nextInt();

            BitSet bitSet1 = new BitSet(n);
            BitSet bitSet2 = new BitSet(n);


            Map<Integer, BitSet> bitSetMap = new HashMap<>();

            bitSetMap.put(1, bitSet1);
            bitSetMap.put(2, bitSet2);

            while (m-- > 0) {


                String operator = in.next();
                ;
                Integer arg1 = in.nextInt();
                Integer arg2 = in.nextInt();

                switch (operator) {

                    case "AND":
                        bitSetMap.get(arg1).and(bitSetMap.get(arg2));
                        System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
                        break;
                    case "SET":
                        bitSetMap.get(arg1).set(arg2);
                        System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
                        break;
                    case "FLIP":
                        bitSetMap.get(arg1).flip(arg2);
                        System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
                        break;
                    case "OR":
                        bitSetMap.get(arg1).or(bitSetMap.get(arg2));
                        System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
                        break;
                    case "XOR":
                        bitSetMap.get(arg1).xor(bitSetMap.get(arg2));
                        System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
                        break;


                }
            }
        }


        //https://www.hackerrank.com/challenges/java-dequeue
        public void uniqueNumbersInSubDequeCounter() {
            Scanner in = new Scanner(System.in);
            Deque<Integer> deque = new ArrayDeque<>();
            Set<Integer> set = new HashSet<>();

            int n = in.nextInt();
            int m = in.nextInt();


            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();

                deque.add(num);
                set.add(num);

                if (deque.size() == m) {
                    if (set.size() > max) {
                        max = set.size();
                    }

                    int first = deque.remove();
                    if (!deque.contains(first)) {
                        set.remove(first);
                    }

                }
            }
            System.out.println(max);
        }


        //https://www.hackerrank.com/challenges/java-comparator
/*
    class Checker implements Comparator<Player> {
        @Override
        public int compare(Player a, Player b) {
            if(a.score==b.score){
                return (int) Math.signum(a.name.compareTo(b.name));
            }
            return (int) Math.signum(b.score-a.score);
        }
    }
*/

        //https://www.hackerrank.com/challenges/java-generics
/*
    public class Solution<T> {

        public Solution(T[] array) {
            for (T element :
                    array) {
                System.out.println(element);
            }
        }

        public static void main(String[] args) {
            Integer[] numbers = {1,2,3};
            String[] words = {"Hello", "World"};

            Solution<Integer> output1 = new Solution<>(numbers);

            Solution<String> output2 = new Solution<>(words);

        }
    }
*/


        //https://www.hackerrank.com/challenges/java-hashset
        public static void numbersOfUniquePairs() {
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            String[] pair_left = new String[t];
            String[] pair_right = new String[t];

            for (int i = 0; i < t; i++) {
                pair_left[i] = s.next();
                pair_right[i] = s.next();
            }


            Set<String> names = new HashSet<>();
            int numberOfUniquePairs = 0;
            for (int i = 0; i < t; i++) {

                if (names.add(pair_left[i] + ", " + pair_right[i])) {
                    numberOfUniquePairs++;
                    System.out.println(numberOfUniquePairs);
                } else {
                    System.out.println(numberOfUniquePairs);
                }
            }
        }


        //https://www.hackerrank.com/challenges/java-negative-subarray
        public static void countNegativeSumsOfSubArrays() {
            Scanner in = new Scanner(System.in);

            int countNegativeSumsOfSubArrays = 0;

            int lengthOfArray = in.nextInt();

            int[] array = new int[lengthOfArray];


            for (int i = 0; i < lengthOfArray; i++) {
                array[i] = in.nextInt();
            }

            for (int i = 0; i < lengthOfArray * lengthOfArray; i++) {
                for (int j = i + 1; j < lengthOfArray + 1; j++) {
                    if (Math.signum(Arrays.stream(Arrays.copyOfRange(array, i, j)).sum()) == -1) {
                        countNegativeSumsOfSubArrays++;
                    }
                }
            }
            System.out.println(countNegativeSumsOfSubArrays);
        }

        //https://www.hackerrank.com/challenges/java-biginteger
        public static void additionAndMultiplicationBigIntegers(String firstNum, String secondNum) {
            System.out.println(new BigInteger(firstNum).add(new BigInteger(secondNum)));
            System.out.println(new BigInteger(firstNum).multiply(new BigInteger(secondNum)));
        }


        //https://www.hackerrank.com/challenges/java-primality-test
        public static String primalityTest(String n) {
            return new BigInteger(n).isProbablePrime(1) ? "prime" : "not prime";
        }


        //https://www.hackerrank.com/challenges/drawing-book
        public static int pageCounter(int n, int p) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

            int fromEnd = 0;
            int fromBeginning = 0;

            for (int j = 0; j <= n / 2; j++) {//создание книги с n страниц
                lists.add(new ArrayList<>());
            }

            for (int j = 0; j <= n; j += 2) {//вставка страниц в книгу
                ArrayList<Integer> list;

                list = lists.get(j / 2);
                list.add(j);
                list.add(j + 1);
            }

            //подсчёт перелистываний от начала книги до нужной страницы
            for (int i = 0; i < lists.size(); i++) {
                ArrayList<Integer> list = lists.get(i);
                for (Integer integer : list) {
                    if (integer == p) {
                        fromBeginning = i;
                        break;
                    }
                }
            }

            //подсчёт перелистываний от конца книги до нужной страницы
            for (int i = lists.size(); i > 0; i--) {
                ArrayList<Integer> list = lists.get(i - 1);
                for (Integer integer : list) {
                    if (integer == p) {
                        fromEnd = lists.size() - i;
                        break;
                    }
                }
            }

            return Math.min(fromBeginning, fromEnd);

        }


        //https://www.hackerrank.com/challenges/java-arraylist
        public void ArrayLister() {
            Scanner in = new Scanner(System.in);
            int linesCount = in.nextInt();

            List<ArrayList<Integer>> lists = new ArrayList<>();
            lists.add(null);
            while (linesCount-- > 0) {
                int line = in.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                list.add(null);
                lists.add(list);
                while (line-- > 0) {
                    list.add(in.nextInt());
                }
            }

            int queryCount = in.nextInt();
            while (queryCount-- > 0) {
                int query = in.nextInt();
                try {
                    System.out.println(lists.get(query).get(in.nextInt()));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("ERROR!");
                }
            }
        }

        //https://www.hackerrank.com/challenges/java-exception-handling
        public static class MyCalculator {
            public static long power(int n, int p) throws Exception {

                if (n == 0 && p == 0) {
                    throw new Exception("n and p should not be zero.");
                } else if (n < 0 || p < 0) {
                    throw new Exception("n or p should not be negative.");
                } else {
                    return (long) Math.pow(n, p);
                }
            }
        }

        //https://www.hackerrank.com/challenges/tag-content-extractor
        public static void TagContentExtractor() {
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());

            while (testCases-- > 0) {
                String str = in.nextLine();

                boolean matchFound = false;
                Pattern pattern = Pattern.compile("<(.+)>([^<]+)</\\1>");
                Matcher matcher = pattern.matcher(str);

                while (matcher.find()) {
                    System.out.println(matcher.group(2));
                    matchFound = true;
                }
                if (!matchFound) {
                    System.out.println("None");
                }
            }
        }

        //https://www.hackerrank.com/challenges/valid-username-checker
        public static boolean usernameValidator(String username) {
            String regex = "^[A-Za-z]\\w{7,29}";
            Pattern pattern = Pattern.compile(regex);
            return username.matches(pattern.pattern());
        }

        public static void Lister() {
            Scanner in = new Scanner(System.in);

            String[] arr;
            ArrayList<String> list;

            String insertElem;

            int countQuery;
            int cq = 0;


            arr = in.nextLine().split(" ");
            list = new ArrayList<>(Arrays.asList(arr));


            countQuery = Integer.parseInt(in.next());

            while (cq != countQuery) {

                String query = in.nextLine();

                if (query.equals("Insert")) {

                    insertElem = in.nextLine();
                    int index = Integer.parseInt(insertElem.replaceAll("\\D\\S+", ""));
                    String data = insertElem.replaceAll("\\S+\\D", "");
                    list.add(index, data);
                    cq++;
                } else if (query.equals("Delete")) {

                    int index = Integer.parseInt(in.nextLine());
                    list.remove(index);
                    cq++;
                }
            }
            list.forEach(x -> System.out.print(x + " "));

        }

        public static void Splitter(String str) {
            str = str.trim();
            String[] result = str.split("[ ,!?._'@]+");

            if (str.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(result.length);
            }
            for (String v : result) {
                System.out.println(v);
            }
        }

        public static boolean isAnagram(String a, String b) {
            char[] arr = a.concat(b).toLowerCase().toCharArray();
            int n = 0;
            for (char c : arr) {
                for (char value : arr) {
                    if (c == value) {
                        n++;
                    }
                }
                if (n % 2 != 0) {
                    return false;
                }
                n = 0;
            }
            return true;
        }

        public static boolean ipValidator(String str) {
            String regex = "((2[0-5][0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|([0-9][0-9]{1}))(\\.|$)){4}";
            Pattern pattern = Pattern.compile(regex);
            return str.matches(pattern.pattern());
        }

        public static void PatternCompileValidator(String str) {
            Scanner in = new Scanner(System.in);
            try {
                Pattern.compile(str);
                System.out.println("Valid");

            } catch (PatternSyntaxException | NumberFormatException e) {
                System.out.println("Invalid");

            }
        }
    }
