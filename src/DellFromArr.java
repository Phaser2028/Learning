public class DellFromArr {
    public static int[] NewArr(int[] arr, int n) {
        int rc = 0;
        int q = 0;
        for (int j : arr) {
            if (j == n) {
                rc++;
            }
        }

        int arr_2[] = new int[arr.length - rc];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != n) {
                arr_2[i - q] = arr[i];
            } else {
                q++;
            }

        }
        return arr_2;
    }

}
