import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class insertionSort {



    public static void sortAscending(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int dog = data[i];
            int j = i;
            while (j > 0 && data[j - 1] > dog) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = dog;
        }
        //return sortAscending(data);
    }
    public static void sortDescending(int[] data){
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int hop = data[i];
            int j = i;
            while (j > 0 && data[j - 1] < hop) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = hop;
        }
    }
}


