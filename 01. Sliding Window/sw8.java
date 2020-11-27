class StringPermutation {
	public static boolean findPermutation(String str, String pattern) {
		int windowStart = 0, matched = 0;
		HashMap<Character, Integer> charFreqMap = new HashMap<>();

		for(char chr : pattern.toCharArray()){
			charFreqMap.put(chr, charFreqMap.getOrDefault(chr, 0) +1);
		}
		// our goal is to match all the characters from the 'charFrequencyMap' with the current window
	    // try to extend the range [windowStart, windowEnd]
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
			char rightChar = str.charAt(windowEnd);
			if(charFreqMap.containsKey(rightChar)){
				// decrement the frequency of the matched character
				charFreqMap.put(rightChar, charFreqMap.get(rightChar)-1);
				if(charFreqMap.get(rightChar) == 0){
					matched ++;
				}
			}
			if(matched == charFreqMap.size())
				return true;
			if(windowEnd >= pattern.length() -1){
				char leftChar = str.charAt(windowStart++);
				if(charFreqMap.containsKey(leftChar)){
					if(charFreqMap.get(leftChar) == 0)
						matched--;// before putting the character back, decrement the matched count
             		// put the character back for matching
					charFreqMap.put(leftChar,charFreqMap.get(leftChar) +1);
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
  }
}


import java.util.*;
class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int windowStart = 0, matched = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    for (char chr : pattern.toCharArray())
      charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
    // our goal is to match all the characters from the 'charFrequencyMap' with the current window
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if (charFrequencyMap.containsKey(rightChar)) {
        // decrement the frequency of the matched character
        charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
        if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
          matched++;
      }
      if (matched == charFrequencyMap.size())
        return true;
      if (windowEnd >= pattern.length() - 1) { // shrink the window by one character
        char leftChar = str.charAt(windowStart++);
        if (charFrequencyMap.containsKey(leftChar)) {
          if (charFrequencyMap.get(leftChar) == 0)
            matched--; // before putting the character back, decrement the matched count
          // put the character back for matching
          charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
        }
      }
    }
    return false;
  }
  public static void main(String[] args) {
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
  }
}
