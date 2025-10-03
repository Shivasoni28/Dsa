class Solution {
    public boolean check(int[] nums) {
     int k=0;
     int n=nums.length;
     for(int i=0;i<nums.length;i++){
        if(nums[i]>nums[(i+1)%n]){
          k++;  
        }
        if(k>1){
            return false;
        }
     }
     return true;   
    }
}
