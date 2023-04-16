package HabrTasks.BinarySearch;

public class BinarySearch {
    /*
        int[] array = {1, 1, 3, 4, 5, 66, 7, 8, 9, 10, 11, 112, 256};
        new main.java.HabrTasks.BubleSort.BubbleSort(array);
        System.out.println(new main.java.HabrTasks.BinarySearch.BinarySearch().BSearch(array,66));
        -->true
     */
    public boolean BSearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        if (value > array[array.length - 1]) {
            return false;

        } else if (value < array[0]) {
            return false;
        }
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] == value) {
                return true;
            }
        }
        return false;
    }
}
