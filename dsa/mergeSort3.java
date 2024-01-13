package dsa;

public class mergeSort3 {
  // function to merge the 3 parts of the array using 3 way merging
  void merge(int arr[], int low, int m1, int m2, int high, int f[]) {
    int i = low, j = m1, k = m2, l = low;
    // comparing the elements of the 3 parts and putting into final array
    while ((i < m1) && (j < m2) && (k < high)) {
      if (arr[i] < arr[j]) {
        if (arr[i] < arr[k])
          f[l++] = arr[i++];
        else
          f[l++] = arr[k++];
      } else {
        if (arr[j] < arr[k])
          f[l++] = arr[j++];
        else
          f[l++] = arr[k++];
      }
    }
    // if the first and second part has the remaining values
    while ((i < m1) && (j < m2)) {
      if (arr[i] < arr[j])
        f[l++] = arr[i++];
      else
        f[l++] = arr[j++];
    }
    while ((j < m2) && (k < high)) {
      if (arr[j] < arr[k])
        f[l++] = arr[j++];
      else
        f[l++] = arr[k++];
    }
    // if the first and third part has the remaining values
    while ((i < m1) && (k < high)) {
      if (arr[i] < arr[k])
        f[l++] = arr[i++];
      else
        f[l++] = arr[k++];
    }
    // copy remaining values from the first part
    while (i < m1)
      f[l++] = arr[i++];
    // copy remaining values from the second part
    while (j < m2)
      f[l++] = arr[j++];
    // copy remaining values from the third part
    while (k < high)
      f[l++] = arr[k++];
  }

  // function to sort the array recursively
  void sort_recursive(int arr[], int low, int high, int f[]) {
    int m1, m2;
    // if there is only one element in the array then return
    if (high - low < 2)
      return;
    // dividing the array into 3 parts
    // one is from low to m1, the second part is from m1 to m2
    // third part is from m2 to high
    m1 = low + ((high - low) / 3);
    m2 = low + 2 * ((high - low) / 3) + 1;
    // calling the recursive function for 3 parts separately
    sort_recursive(f, low, m1, arr);
    sort_recursive(f, m1, m2, arr);
    sort_recursive(f, m2, high, arr);
    // Merging the sorted parts of the array
    merge(f, low, m1, m2, high, arr);
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
      for (i = 0; i < n; i++)
        arr[i] = duplicate[i];
    }
  }
}