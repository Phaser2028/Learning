package HabrTasks;

public class MinAvgMax {
    public MinAvgMax(double[] array){

        double min = array[0];
        double max = array[0];
        double avg = 0;

        for (double v : array) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
            avg += v / array.length;
        }

        System.out.println("max = "+max);
        System.out.println("min = "+min);
        System.out.println("avg = "+avg);

    }
}
