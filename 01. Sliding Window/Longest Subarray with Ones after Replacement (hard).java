//跟前一题一样，就是算0的个数，如果0到了k个，再计算总体长度
//我也不知道错哪里了。。。。
//yes!!!!我写对啦
//注意一定要注意windowEnd是角标，一定要加上arr[windowEnd]
//arr.length和str.length()一定不能弄混


class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
  	if(arr == null || arr.length == 0 || k > arr.length)
  		throw new IllegalArgumentException();

  	int windowStart = 0;
  	int maxLength = 0;

  	Map<Integer, Integer> replacingarr = new HashMap<>();

  	for(int windowEnd = 0; windowEnd < arr.length; windowEnd ++){
  		replacingarr.put(arr[windowEnd], replacingarr.getOrDefault(arr[windowEnd], 0) + 1);

  		while(replacingarr.get(0) > k){
  			replacingarr.put(arr[windowStart], replacingarr.get(arr[windowStart]) - 1);
  			windowStart++;
  		}

  		maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

  	}

  	return maxLength;
  }
}



class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int windowStart = 0, maxLength = 0, maxOnesCount = 0;
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      if (arr[windowEnd] == 1)
        maxOnesCount++;

      // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
      // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
      // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
      // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
      // are not allowed to replace more than 'k' Os
      if (windowEnd - windowStart + 1 - maxOnesCount > k) {
        if (arr[windowStart] == 1)
          maxOnesCount--;
        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
    System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
  }
}

