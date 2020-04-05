package leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class E_1_TwoSum {
	
	
public int[] twoSum_solution_1(int[] nums, int target) {
	
	
	
	
	for(int i=0;i<nums.length;i++){
		
		for(int j=i+1;j<nums.length;j++){
			if(target == nums[i]+nums[j])
				return new int[]{i,j};
		}
	}
	
     return null;   
    }
	
//solution using hashmap. Iterating twice over hashmap
public int[] twoSum_solution_2(int[] nums, int target) {

	
	Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
	
	for(int i=0;i<nums.length;i++)
		elements.put(nums[i], i);
	
	for(int i=0;i<nums.length;i++){
		int complement = target - nums[i];
		if(elements.containsKey(complement) && i!=elements.get(complement)){
			return new int[]{i,elements.get(complement)};
		}
	}
	
	
	
	return null;
}

///solution using hashmap. Iterating once over hashmap
public int[] twoSum_solution_3(int[] nums, int target) {

	
	Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
	
	for(int i=0;i<nums.length;i++){
		int complement = target - nums[i];
		if(elements.containsKey(complement) && i!=elements.get(complement)){
			return new int[]{i,elements.get(complement)};
		}
		
		
		elements.put(nums[i], i);
	}

	
	return null;
}

	
	public static void main(String[] args) {
		
	}
}
