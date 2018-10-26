class Solution {
    class Number {
        int val;
        int count;
        int index;
        public Number (int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return null;
        }
        Number[] numbers = getNumbers(nums);
        
        mergeSort(numbers, 0, numbers.length - 1, new Number[numbers.length]);
        
        List<Integer> result = new ArrayList<>();
        
        int[] count = new int[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i].index] = numbers[i].count;
        }
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }
    private void mergeSort(Number[] nums, int start, int end, Number[] temp) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        
        mergeSort(nums, start, mid, temp);
        mergeSort(nums, mid + 1, end, temp);
        
        helper(nums, start, mid, end);
        
        merge(nums, start, mid, end, temp);
    }
    private void helper(Number[] nums, int start, int mid, int end) {
        int j = mid + 1;
        int c = 0;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i].val > nums[j].val) {
                j++;
                c++;
            }
            nums[i].count = nums[i].count + c;
        }
    }
    private void merge(Number[] nums, int start, int mid, int end, Number[] temp) {
        int index = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (nums[left].val < nums[right].val) {
                temp[index++] = nums[left++];
            } else {
                 temp[index++] = nums[right++];
            }
        }
        while (left <= mid) {
             temp[index++] = nums[left++];
        }
        while (right <= end) {
             temp[index++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
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