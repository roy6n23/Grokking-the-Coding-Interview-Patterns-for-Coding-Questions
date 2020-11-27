import java.util.*;
class NoRepeatSubstring {
  public static int findLength(String str) {
    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      // if the map already contains the 'rightChar', shrink the window from the beginning so that
      // we have only one occurrence of 'rightChar'
      if (charIndexMap.containsKey(rightChar)) {
        // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
        // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
        windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);  //搞清楚这里为什么要用MAX啊，
		//为了固定start,避免出现回流，如果之前的又出现了就还是从之前的start开始算，需要手动推导才能方便理解
        //windowStart = charIndexMap.get(rightChar) + 1;
      }
      charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }
    return maxLength;
  }
  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }
}


class NoRepeatSubstring {
	public static int findLength(String str) {
		int windowStart = 0, maxLength = Integer.MIN_VALUE;
		HashMap<Character, Integer> charIndexMap = new HashMap<>();

		for(int windowEnd = 0 ; windowEnd < str.length(); windowEnd++){
			char rightChar = str.charAt(windowEnd);
			if(charIndexMap.containsKey(rightChar)){
				windowStart = Math.max(windowStart, charIndexMap.get(rightChar)+1);
			}
			charIndexMap.put(rightChar, windowEnd);
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		return maxLength;
	}
}