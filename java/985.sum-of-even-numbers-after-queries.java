class Solution {
    class Counter {
        int[] data;
        int sum;
        public Counter(int[] nums) {
            data = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
                if (nums[i] % 2 == 0) {
                    sum += nums[i];
                }
            }
        }
        public int add(int[] query) {
            int index = query[1];
            int value = query[0];
            int origin = data[index];
            sum -= origin % 2 == 0 ? origin : 0;      
            data[index] += value;
            sum += data[index] % 2 == 0 ? data[index] : 0;
            return sum;
        }
    }
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        Counter counter = new Counter(A);
        int[] ans = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = counter.add(query);
        }
        return ans;
    }
}