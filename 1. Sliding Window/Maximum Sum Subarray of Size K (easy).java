class MaxSumSubArrayOfSizeK {
  	public static int findMaxSumSubArray(int k, int[] arr) {

  	int result = 0;
    int finalres = 0;
  	int windowStart = 0;
  	for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
  		result += arr[windowEnd];

  		if(windowEnd >= k - 1){
  			finalres = Math.max(finalres, result);
  			result -= arr[windowStart];
  			windowStart++;
  	}
    return finalres;
  }
	public static void main(String[] args) {
	    System.out.println("Maximum sum of a subarray of size K: "
	        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
	    System.out.println("Maximum sum of a subarray of size K: "
	        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
	  }
}