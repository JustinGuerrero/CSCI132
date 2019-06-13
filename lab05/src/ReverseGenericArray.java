import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Lab 5
 * Given a method that reverses the int elements in an array,
 * modify it so that it is generic and reverses elements of any type array.
 * When it is finished, rename it to ReverseGenericArray.java
 *
 * Make each array contain at least 5 elements.
 * Song is a class you will write. It should contain fields for title and artist,
 * as well as a 'toString' method to override Arrays.toString
 *
 * Test it with Integer, String, and Song arrays.
 *
 */

    /**
     * TODO: make this generic
     * (BIG Hint: see page 95 of book!)
     *
     */

    public class ReverseGenericArray {
        public static <T> void reverse(T[] data) {
            int low = 0, high = data.length - 1;
            while (low < high) {            // swap data[low] and data[high]
                T temp = data[low];
                data[low++] = data[high];    // post-increment of low
                data[high--] = temp;        // post-decrement of high
            }
        }


        public static void main(String[] args) {

            String[] StringO = {"this",  "is ", "neato"};

            // test with an array of strings (done)
            Integer[] myInts = new Integer[8];
            for (int i = 0; i < myInts.length; i++) {
                myInts[i] = (i + 1) * 2;
            }
            // Using the Arrays API to print the string
            System.out.println(Arrays.toString(myInts));

            ReverseGenericArray.reverse(myInts);
            System.out.println(Arrays.toString(myInts));


            /**
             *  test with an array of Strings...
             */


            String[] myString = new String[3];
            for (int i = 0; i < myString.length; i++) {
                myString[i] = StringO[i];
            }
            // Using the Arrays API to print the string
            System.out.println(Arrays.toString(myString));

            ReverseGenericArray.reverse(myString);
            System.out.println(Arrays.toString(myString));



            Song[] songo = new Song[4];
            songo[0] = new Song("Billy Jean", "Michael Jackson");
            songo[1] = new Song("Drippin in gold", "Justin Guerrero");
            songo[2] = new Song("Righteous", "dirty dog");
            songo[3] = new Song("No sleep til brooklyn", "Beastie boys");


            System.out.println(Arrays.toString(songo));

            ReverseGenericArray.reverse(songo);
            System.out.println(Arrays.toString(songo));


    }


            /**
             *  test with an array of Songs...
             *  You must write the Song class -- see above.
             */

        }




