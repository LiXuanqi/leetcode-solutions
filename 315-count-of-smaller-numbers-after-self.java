class Solution {
    class Number {
        int val;
        int index;
        int count;
        public Number(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Number[] numbers = getNumbers(nums);
        mergeSort(numbers, 0, numbers.length - 1, new Number[numbers.length]);
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < numbers.length; i++) {
            result[numbers[i].index] = numbers[i].count;
        }
        for (int i = 0; i < result.length; i++) {
            ans.add(result[i]);
        }
        return ans;
    }
    private void mergeSort(Number[] numbers, int start, int end, Number[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(numbers, start, mid, temp);
        mergeSort(numbers, mid + 1, end, temp);
        
        helper(numbers, start, end);
        
        merge(numbers, start, end, temp);
    }
    // find i < j, num[i] > nums[j]
    private void helper(Number[] numbers, int start, int end) {
        int mid = start + (end - start) / 2;
        int count = 0;
        int right = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (right <= end && numbers[i].val > numbers[right].val) {
                count++;
                right++;
            }
            numbers[i].count += count;
        }
    }
    private void merge(Number[] numbers, int start, int end, Number[] temp) {
        int mid = start + (end - start) / 2;
        int pointer1 = start;
        int pointer2 = mid + 1;
        int index = start;
        while (pointer1 <= mid && pointer2 <= end) {
            if (numbers[pointer1].val < numbers[pointer2].val) {
                temp[index++] = numbers[pointer1++];
            } else {
                temp[index++] = numbers[pointer2++];
            }
        }
        while (pointer1 <= mid) {
            temp[index++] = numbers[pointer1++];
        }
        while (pointer2 <= end) {
            temp[index++] = numbers[pointer2++];
        }
        for (int i = start; i <= end; i++) {
            numbers[i] = temp[i];
        }
    }
    private Number[] getNumbers(int[] nums) {
        Number[] numbers = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new Number(nums[i], i);
        }
        return numbers;
    }
}