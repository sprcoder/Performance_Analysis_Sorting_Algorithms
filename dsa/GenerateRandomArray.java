package dsa;
import java.util.Scanner;
import java.util.concurrent.*;
import dsa.cocktailSort;
import dsa.cocktailSortReverse;


import javax.xml.transform.Source;

import java.util.Scanner;

public class GenerateRandomArray {
  public static void main(String[] args) {
    int num_array = 0;
    int arr_length = 0;
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter the total number of array");
    num_array = myObj.nextInt();
    System.out.println("Enter the no.of elements in an array");
    arr_length = myObj.nextInt();
    System.out.println("Choose sorting");
    int sort = myObj.nextInt();
    int[][] arrCol = new int[num_array][arr_length];
    System.out.println("Starting array creation");
    for (int i = 0; i < num_array; i++) {
      for (int j = 0; j < arr_length; j++) {
        arrCol[i][j] = ThreadLocalRandom.current().nextInt(0, arr_length);
        // if(i == 0 && j <= 5){
        //   System.out.println(arrCol[i][j]);
        // }
      }
    }
    System.out.println("Array creation is done");
    System.out.println("Starting cocktail sort");
    long start, end, elapsedTime;
    long avg_cocktail_time = 0;

    for (int i = 0; i < num_array; i++){
      start = System.nanoTime();
      switch(sort){
        case 1: 
          cocktailSort cs = new cocktailSort(); 
          cs.cocktailSortI(arrCol[i], arr_length); 
          break;
        case 2: 
          cocktailSortReverse csr = new cocktailSortReverse(); 
          csr.cocktailSortReverseI(arrCol[i], arr_length); 
          break;
        case 3:
          MergeSort ms = new MergeSort();
          ms.mergeSortI(arrCol[i], arr_length);
          break;
        case 4:
          mergeSort3 ms3 = new mergeSort3();
          ms3.sort(arrCol[i], arr_length);
          break;
        case 5:
          mergeSort25 ms25 = new mergeSort25();
          ms25.sort(arrCol[i], arr_length);
          break;
        case 6:
          quickSort qs = new quickSort();
          qs.quickSortI(arrCol[i], 0, arr_length-1);
          break;
        case 7:
          randomqs rqs = new randomqs();
          rqs.sort(arrCol[i], 0, arr_length-1);
      }
      end = System.nanoTime();
      elapsedTime = end - start; 
      avg_cocktail_time += elapsedTime;
    }
    System.out.println("Total time taken:"+ avg_cocktail_time/num_array);
    long milli = TimeUnit.NANOSECONDS.toMillis(avg_cocktail_time/num_array);
    System.out.println(milli);
    long seconds = TimeUnit.NANOSECONDS.toSeconds(avg_cocktail_time/num_array);
    System.out.println(seconds);

  }

}