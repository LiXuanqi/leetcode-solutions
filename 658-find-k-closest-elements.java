class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int counter = k;
      List<Integer> result = new ArrayList<>();
      if (arr == null || k == 0) {
          return result;
      }
      int start = 0;
      int end = arr.length - 1;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          if (arr[mid] <= x) {
              start = mid;
          } else {
              end = mid;
          }
      }
      while (k > 0) {
          if (start >= 0 && end < arr.length) {
              if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                  start--;
              } else {
                  end++;
              }
          } else if (start >= 0 && end >= arr.length) {
              start--;
          } else if (start < 0 && end < arr.length) {
              end++;
          } else {
              break;
          }
        
          k--;
      }
      int[] temp = Arrays.copyOfRange(arr, start + 1, start + 1 + counter);
      for (int i = 0; i < temp.length; i++) {
          result.add(temp[i]);
      }
      
      return result;
  }
}

// corner case: [1]