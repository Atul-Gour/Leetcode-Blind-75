class Solution {
    void calculate(List<List<Integer>> list , int index , int[] candidates, int target , List<Integer> curr , int sum){
        if(sum == target){
            list.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target || index>=candidates.length){
            return;
        }
        for(int i=index; i < candidates.length ; i++){
            if(i>index && candidates[i] == candidates[i-1])continue;
            curr.add(candidates[i]);
            calculate(list , i+1 , candidates , target , curr , sum + candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum =0;
        List<List<Integer>> list = new ArrayList<>();
        calculate(list , 0 , candidates , target , new ArrayList<>() , 0);
        return list;
    }
}