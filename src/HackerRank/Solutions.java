package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;



public class Solutions {

    public  static void Lister() {
        final Scanner in = new Scanner(System.in);

        String[] arr;
        ArrayList<String> list;

        String insertElem;

        int countQuery;
        int cq = 0;

        System.out.print("Введите массив:");
        arr = in.nextLine().split(" ");//1. Запрос

        list = new ArrayList<>(Arrays.asList(arr));
        list.forEach(x -> System.out.print(x + " "));
        System.out.println("\n");

        System.out.print("Введите кол-во запросов:");
        countQuery = Integer.parseInt(in.nextLine());

        while (cq!=countQuery) {
            System.out.print("Введите запрос:");
            String query = in.nextLine();//3. Запрос

            if (query.equals("Insert")) {
                System.out.println("Введите сначала индекс, затем значение:");
                insertElem = in.nextLine();

                int index = Integer.parseInt(insertElem.replaceAll("\\D\\S+", ""));
                String data = insertElem.replaceAll("\\S+\\D", "");
                list.add(index, data);
                list.forEach(x -> System.out.print(x + " "));
                System.out.println("\n");

                cq++;
            } else if (query.equals("Delete")) {
                System.out.println("Введите индекс:");
                int index = Integer.parseInt(in.nextLine());//4. Запросы
                list.remove(index);
                list.forEach(x -> System.out.print(x + " "));
                System.out.println("\n");

                cq++;
            }
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
