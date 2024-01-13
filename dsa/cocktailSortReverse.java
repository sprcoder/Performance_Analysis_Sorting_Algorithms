package dsa;
import java.util.Arrays;

public class cocktailSortReverse {
  static int temp;

  void cocktailSortReverseI(int a[], int n) {
    boolean swap = true;
    int begin = 0, i;
    int end = n - 1;
    while (swap) {
      swap = false;
      for (i = begin; i < end; ++i) {
        if (a[i] < a[i + 1]) {
          temp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = temp;
          swap = true;
        }
      }
      if (!swap)
        break;
      swap = false;
      for (i = end - 1; i >= begin; --i) {
        if (a[i] < a[i + 1]) {
          temp = a[i];
          a[i] = a[i + 1];
          a[i + 1] = temp;
          swap = true;
        }
      }
      ++begin;
    }
    for(i = 0; i < n/2; i++){
      temp = a[i];
      a[i] = a[n-i-1];
      a[n-i-1] = temp;
    }
  }
}