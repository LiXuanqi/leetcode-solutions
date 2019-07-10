class NumArray {
    int[] C,A;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.C = new int[n+1];
        this.A = nums;
        
        for (int i = 0; i < n; i++) {
            add(i,A[i]);
        }   
    }
    
    public void update(int i, int val) {
        int old = A[i];
        A[i] = val;
        add(i, val - old);
    }
    
    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
    
    private void add(int index, int value) {
        index++;
        for (int i = index; i < n + 1; i += lowbit(i)) {
            C[i] += value; 
        }
    }
    
    private int sum(int x) {
        x++;
        int result = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            result = result + C[i];
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */