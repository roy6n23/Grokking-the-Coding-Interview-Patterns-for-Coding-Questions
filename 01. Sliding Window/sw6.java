class CharacterReplacement {
	public static int findLength(String str, int k) {
		int windowStart = 0 , maxLength = 0, maxRepeatLetterCount = 0;
		HashMap<Character, Integer> charFreqMap = new HashMap<>();

		for(int windowEnd = 0 ; windowEnd < str.length(); windowEnd++){
			char rightChar = str.charAt(windowEnd);
			charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar,0)+1);
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charFreqMap.get(rightChar));

			while(windowEnd - windowStart + 1 - maxRepeatLetterCount >k){
				char leftChar = str.charAt(windowStart);
				charFreqMap.put(leftChar,charFreqMap.get(leftChar)-1);
				windowStart++;
			}

			 maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
	    }
	    return maxLength;
	}
}


import java.util.*;
class CharacterReplacement {
  public static int findLength(String str, int k) {
    int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
    Map<Character, Integer> letterFrequencyMap = new HashMap<>();
    // try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
      maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));
      // current window size is from windowStart to windowEnd, overall we have a letter which is
      // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter 
      // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
      // if the remaining letters are more than 'k', it is the time to shrink the window as we
      // are not allowed to replace more than 'k' letters
      if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
        char leftChar = str.charAt(windowStart);
        letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }
  public static void main(String[] args) {
    System.out.println(CharacterReplacement.findLength("aabccbb", 2));
    System.out.println(CharacterReplacement.findLength("abbcb", 1));
    System.out.println(CharacterReplacement.findLength("abccde", 1));
  }
}
