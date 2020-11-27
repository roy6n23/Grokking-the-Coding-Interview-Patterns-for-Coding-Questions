class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int windowSum = 0, maxSum = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd]; // add the next element
      // slide the window, we don't need to slide if we've not hit the required window size of 'k'
      if (windowEnd >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= arr[windowStart]; // subtract the element going out
        windowStart++; // slide the window ahead
      }
    }
    return maxSum;
  }
  public static void main(String[] args) {
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
    System.out.println("Maximum sum of a subarray of size K: "
        + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
  }
}

//错误示范
class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {

  	int result = 0;
    int finalres = 0;
  	int windowStart = 0;
  	for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
  		result += arr[windowEnd];

  		if(windowEnd >= k - 1){
  			int temp = result;
  			result -= arr[windowStart];
  			windowStart++;
  			if(temp > result){
  				finalres = temp;
  			}
  			else
  				finalres = result;
  		}
  	}
    return finalres;
  }  
}