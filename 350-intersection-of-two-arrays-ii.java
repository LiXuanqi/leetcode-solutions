class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      int[] result = new int[0];
      if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
          return result;
      }
      ArrayList<Integer> list = new ArrayList<>();
      
      HashMap<Integer, Integer> map = new HashMap<>();
      
      for (int num : nums1) {
          if (!map.containsKey(num)) {
              map.put(num, 0);
          }
          map.put(num, map.get(num) + 1);
      }
      
      for (int num : nums2) {
          if (map.containsKey(num) && map.get(num) != 0) {
              list.add(num);
              map.put(num, map.get(num) - 1);
          } 
      }
      
      result = list.stream().mapToInt(i -> i).toArray();
      return result;
  }
}

// O(n+m);
// Space ?
// how about follow up?
