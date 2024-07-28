
class Solution {
    public int maxSubArray(int[] nums) {
        
        int sum=0;
        int maxsum=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){

            sum=sum+nums[i];

            maxsum=Math.max(sum,maxsum);

            if(sum<0){
                sum=0;
            }
        }
        return maxsum;
    }
}