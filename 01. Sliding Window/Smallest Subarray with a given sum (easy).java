//思路：先滑动最右边的窗口直到大于等于这个值，然后左边的再减少，
//如果满足就记录数值，如果不满足就继续往右划，直到右边到顶点并且左边的到最小值


class MinSizeSubArraySum {

		public static void main(String[] args) {
			int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
			System.out.println("Smallest subarray length: " + result);
			result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
			System.out.println("Smallest subarray length: " + result);
			result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
			System.out.println("Smallest subarray length: " + result);
		}

	  public static int findMinSubArray(int S, int[] arr) {

//不能初始化为0 因为是比较最小值		int numofsubarry = 0;
	  	int numofsubarry = Integer.MAX_VALUE;
		int windowStart = 0;
		int result = 0;

		for( int windowEnd = 0; windowEnd < arr.length; windowEnd++ ){
			result += arr[windowEnd];

			while(result >= S){
				numofsubarry = Math.min(windowEnd - windowStart,numofsubarry);
				result -= arr[windowStart];
				windowStart++;
			}

//不能放在这里，因为只有满足result >= S 这个大小才有意义			numofsubarry = Math.min(windowEnd - windowStart,numofsubarry);
		}
		 return numofsubarry == Integer.MAX_VALUE ? 0 : numofsubarry;
	  }


}

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int windowSum = 0, minLength = Integer.MAX_VALUE;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      windowSum += arr[windowEnd]; // add the next element
      // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
      while (windowSum >= S) {
        minLength = Math.min(minLength, windowEnd - windowStart + 1);
        windowSum -= arr[windowStart]; // subtract the element going out
        windowStart++; // slide the window ahead
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
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