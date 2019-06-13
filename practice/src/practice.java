import java.lang.*;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;


public class practice {

    static int fib(int n) {

        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
    static int fibit(int n){
        int fib1 = 1;
        int fib2 = 1;
        for (int i = 2; i < n ; i++) {
            int fib3 = fib1;
            fib1 = fib2 + fib1;
            fib2 = fib3;


        }
        return fib1;
    }
    static String palandrome(){
        System.out.println("what would you like to check? ");
        Scanner src = new Scanner(System.in);
        String pal = src.nextLine();
        String reverse = "";
        for (int i = pal.length() - 1; i >= 0; i--) {
            reverse = reverse + pal.charAt(i);
        }
        System.out.println("Comparing " + pal + " and " + reverse + " " + " which is " + pal.equals(reverse));

        return palandrome();
    }

    static String charcut(){
        System.out.println("what would you like to say? ");
        Scanner src = new Scanner(System.in);
        String pal = src.nextLine();
        char[] charstring = pal.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(pal);
        System.out.println("what element would you like to remove");
        Scanner remove = new Scanner(System.in);
        int take = remove.nextInt();
        sb.deleteCharAt(take);
        charstring = sb.toString().toCharArray();

        System.out.println(charstring);

        return charcut();
    }


    public static void main(String[] args) {
        practice nice = new practice();
        //palandrome();
        System.out.println(nice.fib(9));
        System.out.println(nice.fibit(9));
        charcut();
        }
    }

