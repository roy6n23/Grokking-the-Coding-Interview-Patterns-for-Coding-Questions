import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();
    int product = 1, left = 0;
    for(int right = 0; right < arr.length; right++){
    	product *= arr[right];
    	while(product >= target && left < arr.length)
    		product /= arr[left++];
    	List<Integer> tempList = new LinkedList<>();
    	for(int i = right; i >= left; i--){
    		tempList.add(0, arr[i]);
    		result.add(new ArrayList<>(tempList));
    	}
    }


    return subarrays;
  }
}
