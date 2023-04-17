package HabrTasks.Strings;

public class Palindrome {
    public static boolean isPalindrome(String text){
        String[] checkedText = text.split("");

        for (int i = 0; i < checkedText.length/2; i++) {
            if(checkedText[i].equals(checkedText[checkedText.length-i-1])){
                continue;
            }
            else {
                return false;
            }

        }
        return true;
    }


}
