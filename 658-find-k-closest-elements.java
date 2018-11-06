class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
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
        List<Integer> result = new LinkedList<>();
        while (start >= 0 && end < arr.length && k > 0) {
            if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                result.add(0, arr[start]);
                start--;
            } else {
                result.add(arr[end]);
                end++;
            }
            k--;
        }
        while (start >= 0 && k > 0) {
            result.add(0, arr[start]);
            start--;
            k--;
        }
        while (end < arr.length && k > 0) {
            result.add(arr[end]);
            end++;
            k--;
        }
        return result;
    }
}