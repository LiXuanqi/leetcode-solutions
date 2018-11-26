class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int i = 0;
        int end = citations.length - 1;
        while (i < citations.length && i < citations[end - i]) {
            i++;
        }
        return i;
    }
}