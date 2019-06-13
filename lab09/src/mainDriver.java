import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class mainDriver {

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);


        insertionSort insert = new insertionSort();
        int size = -1;

        do {
            System.out.println("How big of an array would you like? ");
            String n = src.nextLine();
            try {
                size = Integer.parseInt(n);

            } catch (NumberFormatException a) {
                System.out.println("Please enter an integer");
                continue;

            }
        } while (size < 0);

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        int[] data = new int[size];
        for (int i = 0; i < data.length; i++)
            data[i] = rand.nextInt(size);
        System.out.println("The unsorted array is" + "\n" + Arrays.toString(data));
        int switchIt = 0;
        while(switchIt != 3){

            do {
            System.out.println("For sorting linearly please enter (1), for reverse sort please enter (2), To quit (3): ");
            String input = src.nextLine();

            try {
                switchIt = Integer.parseInt(input);
            } catch(NumberFormatException a) {
                System.out.println("Please enter an integer");
                continue;
            }
        } while (switchIt < 0 && switchIt > 4);
        switch (switchIt) {
            case 1:
                insert.sortAscending(data);
                System.out.println("The sorted array in an linear order is:");
                System.out.println(Arrays.toString(data));
                break;
            case 2:
                insert.sortDescending(data);
                System.out.println("The sorted array in a reverse order is:");
                System.out.println(Arrays.toString(data));
                break;
            case 3:
                break;
            }
        }
    }
}