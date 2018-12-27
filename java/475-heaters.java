class Solution {
  public int findRadius(int[] houses, int[] heaters) {
      Arrays.sort(heaters);
      int dist = Integer.MIN_VALUE;
      for (int house : houses) {
          int closestDist = findClosestHeater(house, heaters);
          if (closestDist > dist) {
              dist = closestDist;
          }
      }
      return dist;
  }
  private int findClosestHeater(int house, int[] heaters) {
      int left = 0;
      int right = heaters.length - 1;
      while (left + 1 < right) {
          int mid = left + (right - left) / 2;
          if (heaters[mid] == house) {
              return 0;
          } else if (heaters[mid] < house) {
              left = mid;
          } else {
              right = mid;
          }
      }
      int diffLeft = Math.abs(heaters[left] - house);
      int diffRight = Math.abs(heaters[right] - house);
      if (diffLeft < diffRight) {
          return diffLeft;
      }
      return diffRight;
  }
}