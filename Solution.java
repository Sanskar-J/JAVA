class Solution {
    public int majorityElement(int[] nums) {
 int count =1,  candidate = nums[0];
        for(int i =1;i<nums.length;i++){
            
            
                if(candidate == nums[i]){
                    count++;
                }
                else{
                    count --;
                }
            if(count ==0){
                candidate = nums[i];
                count =1;
                
            }
            System.out.println(count);
        }
        return candidate;
    }
    public static void main(String a[])
    {
        Solution x=new Solution();
        int q[]={1,1,2,2,2,2,1,1,2,2,1,2,1};
        int y=x.majorityElement(q);

    }
}