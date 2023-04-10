package HabrTasks.Strings;

public class LongestStringInArray {
    public static String searchLongestString(String[] array){
        String longestString=array[0];

        for (int i = 1; i < array.length; i++) {
            if(array[i].length()>longestString.length()){
                longestString=array[i];
            }
        }

        return longestString;


    }


}
