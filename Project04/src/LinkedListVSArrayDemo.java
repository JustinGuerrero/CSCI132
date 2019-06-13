import java.sql.SQLOutput;
import java.util.LinkedList;


public class LinkedListVSArrayDemo {


    public static void main(String[] args) {
        /**
         * the sizes area built will be the array that all the methods will loop through
         * we can change the size, and values within the array to see the difference in time
         * complexity.
         * followed by a for loop to run each method through each iteration
         */
        int[] sizes = new int[]{400, 450, 500, 550};
        for (int i = 0; i < sizes.length; i++) {


            ArrayDS arrayDS = new ArrayDS(sizes[i]);
            arrayDS.randomFill();
            ;

            long startTime1 = System.nanoTime();
            arrayDS.addFirst(5);
            long stopTime1 = System.nanoTime();
            long Elapsed = stopTime1 - startTime1;
            System.out.println("add first Array Method: " + Elapsed + " microseconds");

            long startTime = System.nanoTime();
            arrayDS.addLast(5);
            long stopTime = System.nanoTime();
            long timeElapse = stopTime - startTime;
            System.out.println("add last Array Method: " + timeElapse + " microseconds");


            long startTime2 = System.nanoTime();
            arrayDS.getNth(5);
            long stopTime2 = System.nanoTime();
            long timeElapse2 = stopTime2 - startTime2;
            System.out.println("Receiving the Nth via Array Method: " + timeElapse2 + " microseconds" + "\n");

            System.out.println("Now linked list method");

            LinkedListDS linkedList = new LinkedListDS();
            linkedList.randomFill(sizes[i]);


            long startTiming = System.nanoTime();
            linkedList.addFirst(5);
            long stopTiming = System.nanoTime();
            long Elapsing = stopTiming - startTiming;
            System.out.println("add first Linked List: " + Elapsing + " microseconds");

            long startTiming1 = System.nanoTime();
            linkedList.addLast(5);
            long stopTiming1 = System.nanoTime();
            long Elapsing1 = stopTiming1 - startTiming1;
            System.out.println("add Last Linked List: " + Elapsing1 + " microseconds");

            long startTiming2 = System.nanoTime();
            linkedList.getNth(5);
            long stopTiming2 = System.nanoTime();
            long Elapsing2 = stopTiming2 - startTiming2;
            System.out.println("receiving the Nth via Linked List: " + Elapsing2 + " microseconds" + "\n");

        }
        System.out.println("Results :");
        System.out.println("ArrayDS.addFirst(): -- Linear Time");
        System.out.println("ArrayDS.addLast(): -- Linear Time");
        System.out.println("ArrayDS.getNth(): -- Constant Time");
        System.out.println("------");
        System.out.println("LListDS.addFirst -- Constant Time");
        System.out.println("LListDS.addLast -- Constant Time");
        System.out.println("LListDS.getNth == Linear Time");

    }
}