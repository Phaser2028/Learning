package HackerRank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solutions {

    public void Lister(){
        Scanner in = new Scanner(System.in);
        String[] arr;
        ArrayList<Integer> list = new ArrayList<>();
        //in.nextLine().replaceAll("\\s+", "").split("")

        while (true) {

            int len = in.nextInt();

           arr = in.nextLine().replaceAll("\\s+", "").split("");
           list = new ArrayList<>(Stream.of(Arrays.asList(arr)).forEach(x->Integer.parseInt(x.toString())));






        }
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
    public static boolean ipValidator(String str){
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
