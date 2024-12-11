class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left=1,right=Integer.MAX_VALUE,result=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isFeasible(nums,mid,maxOperations)){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
    private boolean isFeasible(int[] nums,int penalty,int maxOperations){
        int operations=0;
        for(int num:nums){
            operations+=(num-1)/penalty;
            if(operations>maxOperations)return false;
        }
        return true;
    }
}