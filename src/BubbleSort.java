import java.util.Arrays;

public class BubbleSort {


    public BubbleSort(double[] array){

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if(array[j]>array[j+1]){
                    double a = array[j];
                    array[j]=array[j+1];
                    array[j+1]=a;
                }
            }
        }
        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }

    }
}
