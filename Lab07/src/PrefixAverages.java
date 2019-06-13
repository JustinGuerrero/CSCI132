import java.util.Random;

public class PrefixAverages {

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage1 (double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0;
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1);

        }
        return a;
    }

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        double total = 0;
        for (int j = 0; j < n; j++) {
            total += x[j];
            a[j] = total / (j + 1);
        }
        return a;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        double[] array1 = new double[10];
        double[] array2 = new double[100];
        double[] array3 = new double[1000];
        double[] array4 = new double[10000];
        double[] array5 = new double[100000];

        for (int i = 0; i < 10 ; i++) {
            array1[i] = (int)(Math.random()*10);

        }
        for (int i = 0; i < 100 ; i++) {
            array2[i] = (int)(Math.random()*100);

        }
        for (int i = 0; i < 1000 ; i++) {
            array3[i] = (int)(Math.random()*1000);

        }
        for (int i = 0; i < 10000 ; i++) {
            array4[i] = (int)(Math.random()*10000);

        }
        for (int i = 0; i < 100000 ; i++) {
            array5[i] = (int)(Math.random()*100000);

        }
        long startTime = System.nanoTime();
        prefixAverage1(array1);
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println("elapsed time for an array of 10 method one is " + elapsed);

        long startTime2 = System.nanoTime();
        prefixAverage2(array1);
        long endTime2 = System.nanoTime();
        long elapsed2 = endTime2 - startTime2;
        System.out.println("elapsed time for an array of 10 method two is " + elapsed2);

        long startTime3 = System.nanoTime();
        prefixAverage1(array2);
        long endTime3 = System.nanoTime();
        long elapsed3 = endTime3 - startTime3;
        System.out.println("elapsed time for an array of 100 method one is " + elapsed3);

        long startTime4 = System.nanoTime();
        prefixAverage2(array2);
        long endTime4 = System.nanoTime();
        long elapsed4 = endTime4 - startTime4;
        System.out.println("elapsed time for an array of 100 method two is " +  elapsed4);

        long startTime5 = System.nanoTime();
        prefixAverage1(array3);
        long endTime5 = System.nanoTime();
        long elapsed5 = endTime5 - startTime5;
        System.out.println("elapsed time for an array of 1000 method one is " + elapsed5);

        long startTime6 = System.nanoTime();
        prefixAverage2(array3);
        long endTime6 = System.nanoTime();
        long elapsed6 = endTime6 - startTime6;
        System.out.println("elapsed time for an array of 1000 method two is " + elapsed6);

        long startTime7 = System.nanoTime();
        prefixAverage1(array4);
        long endTime7 = System.nanoTime();
        long elapsed7 = endTime7 - startTime7;
        System.out.println("elapsed time for an array of 10000 method one is " + elapsed7);

        long startTime8 = System.nanoTime();
        prefixAverage2(array4);
        long endTime8 = System.nanoTime();
        long elapsed8 = endTime8 - startTime8;
        System.out.println("elapsed time for an array of 10000 method two is " + elapsed8);

        long startTime9 = System.nanoTime();
        prefixAverage1(array5);
        long endTime9 = System.nanoTime();
        long elapsed9 = endTime9 - startTime9;
        System.out.println("elapsed time for an array of 100000 method one is " + elapsed9);

        long startTime10 = System.nanoTime();
        prefixAverage2(array5);
        long endTime10 = System.nanoTime();
        long elapsed10 = endTime10 - startTime10;
        System.out.println("elapsed time for an array of 100000 method two is " + elapsed10);

        System.out.println("The first function you will see takes exponentially more time to run, showing that" +
                "this funciton is a quadratic function.\n");

        System.out.println("The second method is a much more efficient method, showing that it is a linear function");

    }

}
