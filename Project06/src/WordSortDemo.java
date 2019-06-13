/** 
 * Project 6
 * 
 * Use Quicksort or Mergesort (your choice) to sort words from a file
 * by word length, from the longest words to the shortest.
 * You may use the implementation given in the book for Mergesort and/or Quicksort.
 * 
 * Write the output of the program to files Lexicographical.txt and TaleOfTwoCitiesLongToShort.txt.
 * Submit four files for grading:
 * 1. the sorted text file
 * 2. the modified WordSorter Demo program
 * 3. your Quicksort or Mergesort implementation, and
 * 4. the StringLengthComparitor.
 * 
 * Included in this week's content are
 * 1. IOExample.java -- an example program showing how read from and write to files Java 
 * 2. SortExample.java -- an example program demonstrating the use of comparators
 * 3. TaleOfTwoCities.txt -- a text file of Charles Dickens' masterpiece opening to the book
 * 4. WordSortDemo driver file to get you started
 *     
 *     Note: Punctuation marks will be stuck to some of the words. That's fine.
 *     
 *  Grading:
 *  3 pt - Your implementation of Mergesort or Quicksort
 *  2 pt - Your implementation of StringLengthComparitor
 *  1 pt - The text file sorted from longest to shorts word
 *  3 pt - Your modified WordSortDemo program putting it all together
 *  1 pt - Proper use of Javadoc comments and coherent code
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

/**
 *
 * WordSortDemo is meant to check to see if the elements inside of the arrays are
 * greater than one another, and the function mergeSort obviously implements merge sort.
 * merge sort is a useful tool that will break down the arrays into temp arrays to sort
 * the elements inside of an array faster. This function runs in nlog(n) time complexity.
 */


public class WordSortDemo {
    public static<K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> compy){
        int i = 0, j = 0;
        while(i + j < S.length){
            if(j == S2.length ||( i < S1.length && compy.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++];
            else
                S[i+j] = S2[j++];
        }
    }
    public static <K> void mergeSort(K[] S, Comparator<K> comp){
        int n = S.length;
        if (n < 2) return;
        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid); //copy of firt half
        K[] S2 = Arrays.copyOfRange(S, mid, n);         // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp);        // sort copy of first half
        mergeSort(S2, comp);        // sort copy of second half
        // merge results
        merge(S1, S2, S, comp); // merge sorted halves back into original

    }
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/** We want the words of file to be elements in an array, but how many words?
		 Hint: Use ArrayList with its dynamic array as an intermediary.

         the array list and scanner we create here will read in the file and copy each word as an individual string
         the while loop utilizes features from the ArrayList api and adds each element in. after whcich we close the file
         **/
		ArrayList<String> wordAL = new ArrayList<>();
		
		// TODO: Get the file TaleOfTwoCities.txt -- word by word -- into the ArrayList
		// Hint: see IOExample for how to read in a file in. Add every word to the ArrayList.

		Scanner src = new Scanner(new File("TaleOfTwoCities.txt"));
		while(src.hasNext()){
			wordAL.add(src.next());
		}
		src.close();

        // TODO: change this array to contain the words from the Array List (see ArrayList API)
        /**
         * the function to copy each element from the list into an array of string.
         */
		String[] wordArray = new String[wordAL.size()];
		for (int i = 0; i < wordAL.size(); i++) {
			wordArray[i] = wordAL.get(i);

		}
		//System.out.println(Arrays.toString(wordArray));
		// TODO: Make another comparator and instantiate byWordLength (see p 363). Use it instead.
        /**
         * below we override the compare method to compare the string array and the list in order
         * to put the words in the desired order within the array. Logan Vining helped me with this part.
         */
		Comparator<String> byLexigraphical = Comparator.naturalOrder();
        Comparator<String> byWordLength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o1.length() > o2.length()) {
                    return -1;

                } else {
                    return 0;
                }
            }
        };
        // Logan Vining cred for the above code. ^
	
		// TODO: Use Mergesort (book, pp 537-538) or Quicksort (p 553), not Arrays.sort. Sort by length
		Arrays.sort(wordArray, byLexigraphical);
		mergeSort(wordArray, byWordLength);
        System.out.println("hi");
        System.out.println(Arrays.toString(wordArray));




		// TODO: Sort by word length -- longest to shortest -- into a file TaleOfTwoCitiesLongToShort
		try {
			PrintWriter outputFile = new PrintWriter(new FileWriter("TaleOfTwoCitiesDemo.txt"));

			for (String word : wordArray) { 
				outputFile.println(word);
			}

			outputFile.close();
		} catch (IOException exc) {
			System.out.println("There was a problem opening the output file.");
		}
		
		System.out.println("The deed is done.");
		System.out.println("<end>");
	}
}


