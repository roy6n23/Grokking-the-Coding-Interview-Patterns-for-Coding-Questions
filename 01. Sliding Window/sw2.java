class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int windowSum = 0, minLength = Integer.MAX_VALUE;
	int windowStart = 0;
	for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
		windowSum += arr[windowEnd];

		while(windowSum >= S){
			windowSum -= arr[windowStart];
			windowStart++;
		}
		minLength = Math.min(minLength, windowEnd - windowStart +1);
	}

	return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }



  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }
}