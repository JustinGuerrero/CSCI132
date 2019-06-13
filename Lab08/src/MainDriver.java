import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainDriver {
    public static int checks = 0;

    public static void main(String[] args) {


        System.out.println("What is n");
        Scanner src = new Scanner(System.in);

        int n = src.nextInt();

        System.out.println("Choose a number between 1 and " + n + " to have as your target");
        int target = src.nextInt();


        int[] arrayi = new int[n];

        Random rand = new Random();
        for (int i = 0; i < arrayi.length; i++) {
            arrayi[i] = rand.nextInt(n);
        }
        int linearSearch = LinearSearch(arrayi, target, 0);
        System.out.println("found it in the array at element" + linearSearch);
        System.out.println("this took " + checks + " checks to find the number \n");
        checks = 0;
        Arrays.sort(arrayi);
        int binarySearch = binarySearch(arrayi, target, 0, n );
        System.out.println(binarySearch);
        System.out.println("this took " + checks + " checks to find the number");

    }

    public static int binarySearch(int[] data, int target, int low, int high){
        checks ++;
        if (low > high)
            return -1;       // interval empty, no match
        else{
            int mid = (low + high)/2;
            if (target == data[mid]) {
                System.out.print("found it in the sorted array at element ");
                return mid;    // found a match
            }
            else if (target < data[mid])
                return binarySearch(data, target, low, mid -1);     // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high);       // recur right of the middle
        }

    }

    public static int LinearSearch(int[] data, int target, int index){
                checks ++;

                if (index == data.length)
                    return -1;
                else if (data[index] == target)
                    return index;
                else
                    return LinearSearch(data, target, index + 1);


    }

}
