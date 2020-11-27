class TripletSumToZero{
	public static List<List<Integer>> searchTriplet(int[] arr){
		Arrays.sort(arr);
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < arr.length; i++){
			if(i > 0 && arr[i] == arr[i-1])
				continue;
			searchPair(arr, -arr[i], i+1, result);
		}

		return result;
	}

	public static void searchPair(int[] arr, int target, int left, List<List<Integer>> result){
		int right = arr.length -1;
		while(left <right){
			int currentSum = arr[left] +arr[right];
			if(currentSum == target){
				result.add(Arrays.asList(-target, arr[left], arr[right]));
				left++;
				right--;
				while(left < right && arr[left] == arr[left-1])
					left++;
				while(left < right && arr[right] == arr[right+1])
					right--;
			}else if(target > currentSum){
				left++;
			}else{
				right--;
			}


		}
	}
}