package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Solutions {

    //https://www.hackerrank.com/challenges/java-arraylist
    public void ArrayLister(){
        Scanner in = new Scanner(System.in);
        int linesCount = in.nextInt();

        List<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(null);
        while(linesCount-- >0){
            int line = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(null);
            lists.add(list);
            while (line-->0) {
                list.add(in.nextInt());
            }
        }

        int queryCount = in.nextInt();
        while (queryCount-->0){
            int query = in.nextInt();
            try {
                System.out.println(lists.get(query).get(in.nextInt()));
            }
            catch (IndexOutOfBoundsException e){
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
