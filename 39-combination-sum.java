class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> templist, int[] candidates, int remain, int start){
        if(remain < 0){
            return;
        }else if(remain == 0){
           list.add(new ArrayList<>(templist));     
        }else{
            for(int i=start;i<candidates.length;i++){
                templist.add(candidates[i]);
                backtrack(list, templist, candidates, remain-candidates[i], i);
                templist.remove(templist.size() - 1);
            }    
        }
    }
}