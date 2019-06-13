import java.util.Arrays;

public class ArrayDS {

    private double dsArray[];

    public ArrayDS(int X) {
        dsArray = new double[X];
    }
    /** randomFill builds random array and fills with random numbers specified to a given length
     */

    public void randomFill() {

        for (int i = 0; i < dsArray.length; ++i) {
            dsArray[i] = (double) ((int) (Math.random() * dsArray.length));

        }
    }

    /**
     * toString returns the elements in the array to a string method for printable statements
     * @return
     */
    @Override
    public String toString() {
        for (int i = 0; i < dsArray.length; i++) {

        }
        return Arrays.toString(dsArray);
    }

    /**
     * A method addFirst to add elements into an array at the first location. the method
     * will take all the preceding elements and shift them back one, adding an element at the
     * first space in the array, and returning the element.
     * @param whatToAdd
     */


    public void addFirst(double whatToAdd) {
        double[] newArray = new double[dsArray.length + 1];
        newArray[0] = whatToAdd;
        for (int i = 1; i < newArray.length ; i++) {
            newArray[i] = dsArray[i - 1];
        }

    }

    /**
     * similar to add first, addLast will add an element to the end of the list
     * and will make the array one space larger for said element.
     * @param whatToDoNow
     * @return
     */

    public double[] addLast(int whatToDoNow) {
        double[] anotherArray = new double[dsArray.length + 1];
        anotherArray[anotherArray.length -1] = whatToDoNow;
        for (int i = 0; i < dsArray.length; i++) {
            anotherArray[i] = dsArray[i];
        }
        return(anotherArray);
    }

    /**
     * getNth is a method created to pass in a number, and the method
     * will take the number passed, go to that element and return the value
     * in that location.
     * @param index
     * @return
     */

    public double getNth(int index) {
        double value = 0;
        for (int i = 0; i < index ; i++) {
            value = index;
        }

        return(value);

    }

}