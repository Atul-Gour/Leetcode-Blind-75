class Solution {
    void find(int[] nums ,int index ,List<List<Integer>> ans,List<Integer> curr){
        ans.add(new ArrayList<>(curr));
        for(int i=index ; i < nums.length ; i++){
            if(i>index && nums[i]==nums[i-1])continue;
            curr.add(nums[i]);
            find(nums,i+1,ans, curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        find(nums,0,ans, new ArrayList<>());
        return ans;
    }
}