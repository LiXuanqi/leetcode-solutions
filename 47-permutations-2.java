class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, boolean[] used){
        if(templist.size() == nums.length && !list.contains(templist) ){
            list.add(new ArrayList<>(templist));
        }
        for(int i=0; i<nums.length; i++){
            if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            templist.add(nums[i]);
            used[i] = true;
            backtrack(list, templist, nums, used);
            templist.remove(templist.size()-1);
            used[i] = false;
        }
    }
}