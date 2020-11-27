class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
  	List<List<Integer>> result = new ArrayList<>();

  	int left = 0, product = 1;

  	for(int right = 0; right< arr.length; right++){
  		product *= arr[right];
  		while(product >= target && left< arr.length){
  			product /= arr[left++];
  		}
  		List<Integer> tempList = new LinkedList<>();
  		for(int i = right; i >= left; i--){
  			tempList.add(0, add[i]);
  			result.add(new ArrayList<>(tempList));
  		}
  	}
  	return result;
  }
}