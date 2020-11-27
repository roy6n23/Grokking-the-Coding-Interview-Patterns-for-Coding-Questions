import java.util.*;
class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
	int windowStart = 0, maxLength =Integer.MIN_VALUE;
	HashMap<Character, Integer> key2value = HashMap<>();

	for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
		key2value.put(arr[windowEnd], key2value.getOrDefault(arr[windowEnd], 0) +1);

		while(key2value.size() > 2){
			key2value.put(arr[windowStart], key2value.get(arr[windowStart]) -1);
			if(key2value.get(arr[windowStart]) == 0)
				key2value.remove(arr[windowStart]);
			windowStart++;
		}
		maxLength = Math.max(maxLength, windowEnd - windowStart +1);
	}

	return maxLength;
  }
}



import java.util.*;
class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);
      // shrink the sliding window, until we are left with '2' fruits in the frequency map
      while (fruitFrequencyMap.size() > 2) {
        fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart]) - 1);
        if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
          fruitFrequencyMap.remove(arr[windowStart]);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }
  public static void main(String[] args) {
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println("Maximum number of fruits: " + 
                          MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
  }
}
