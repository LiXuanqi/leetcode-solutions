class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list , new ArrayList<>(), s, 0);
        return list;
    }
    private void backtrack(List<List<String>> list, List<String> templist, String s, int start){
        if(s.length() == start){
            list.add(new ArrayList<>(templist));
        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                templist.add(s.substring(start, i+1));
                backtrack(list, templist, s, i+1);
                templist.remove(templist.size()-1);   
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}