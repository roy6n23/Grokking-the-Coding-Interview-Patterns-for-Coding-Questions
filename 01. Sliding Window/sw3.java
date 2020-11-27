class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
  	if (str == null || str.length() == 0 || str.length() < k)
      throw new IllegalArgumentException();

  	int windowStart = 0;
  	int maxLength = Integer.MIN_VALUE;
  	HashMap<Character, Integer> hashMap = new HashMap<>();
  	for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
  		hashMap.put(str.charAt(windowEnd), getOrDefault(str.charAt(windowEnd), 0) +1);

  		while(hashMap.getSize() > k){
  			// maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
  			// hashMap.remove(str.charAt(windowStart));
  			// windowStart++;
  			hashMap.put(str.charAt(windowStart), hashMap.get(str.charAt(windowStart))-1);
  			if(hashMap.get(str.charAt(windowStart)))
  				hashMap.remove(str.charAt(windowStart));
  			windowStart++;
  		}
  		maxLength = maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
  	}
  	return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
  }
}


// 利用滑动窗口，记录某个窗口的元素及其出现的个数
//只有K个，如何判断啊？--------用Map.size()可以进行判断
//个数hashMap可以得到，由Value可以得到的 Map.get()
import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0 || str.length() < k)
      throw new IllegalArgumentException();

    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    // in the following loop we'll try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      while (charFrequencyMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }
}
