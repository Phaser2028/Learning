package HabrTasks.DeleteOccurrencesInTheArray;

public class deleteFromArray {
    public static int[] deleteOccurrences(int[] arrayWithRepeats, int n) {
        int repeatCount = 0;
        int q = 0;

        for (int i : arrayWithRepeats) {
            if (i == n) {
                repeatCount++;
            }
        }

        int[] arrayWithoutRepeats= new int[arrayWithRepeats.length - repeatCount];

        for (int i = 0; i < arrayWithRepeats.length; i++) {

            if (arrayWithRepeats[i] != n) {
                arrayWithoutRepeats[i - q] = arrayWithRepeats[i];
            } else {
                q++;
            }

        }
        return arrayWithoutRepeats;
    }

}
