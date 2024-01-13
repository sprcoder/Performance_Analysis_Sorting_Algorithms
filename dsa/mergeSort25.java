package dsa;

public class mergeSort25 {
  void merge(int arr[], int low, int m1, int high, int f[]) {
    int i = low, j = m1, l = low;
    // comparing the elements of the 3 parts and putting into final array
    while ((i < m1) && (j < high)) {
      if (arr[i] < arr[j]) {
        f[l++] = arr[i++];
      } else {
        f[l++] = arr[j++];
      }
    }
    // if the first and second part has the remaining values
    while (i < m1) {
      f[l++] = arr[i++];
    }
    while (j < high) {
      f[l++] = arr[j++];
    }
  }

  // function to sort the array recursively
  void sort_recursive(int arr[], int low, int high, int f[]) {

    int m1;
    // if there is only one element in the array then return
    if (high - low <= 2){
      if (high - low == 2) {
        if (arr[low] > arr[high - 1]){
          int temp = arr[low];
          arr[low] = arr[high - 1];
          arr[high - 1] = temp;
        }
      }
      return;
    }
    // dividing the array into 3 parts
    // one is from low to m1, the second part is from m1 to m2
    // third part is from m2 to high
    m1 = low + ((high - low) * 2 / 5);

    // calling the recursive function for 3 parts separately

    sort_recursive(f, low, m1, arr);

    sort_recursive(f, m1, high, arr);
    // Merging the sorted parts of the array
    merge(f, low, m1, high, arr);
  }
  
  void sort(int arr[], int n) {
    {
      int i, duplicate[] = new int[n];
      // if there is no element in the array return null
      if (n == 0)
        return;
      // copying the array elements into duplicate array
      for (i = 0; i < n; i++)
        duplicate[i] = arr[i];
      // calling the recursive function to sort the array
      sort_recursive(duplicate, 0, n, arr);
      // copying the elements of duplicate array into original array
      for (i = 0; i < n; i++){
        arr[i] = duplicate[i];
      }
    }
  }
}
