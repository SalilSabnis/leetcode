package leetcode.algorithms;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class E_26_RemoveDuplicatesFromSortedArray {
	
	
	 public static int removeDuplicates(int[] nums) {
		 
		 int count=0;
		 for(int i=1;i<nums.length;i++){
			 if(nums[i] != nums[count]){
				 nums[count+1] = nums[i];
				 count++;
				 
			 }
			 
		 }
		 		 
		 return count+1;
	    }
	
public static void main(String[] args) {
	int nums[]={0,0,1,1,1,2,3,3,3,4};
	System.out.println(removeDuplicates(nums));
}
}
