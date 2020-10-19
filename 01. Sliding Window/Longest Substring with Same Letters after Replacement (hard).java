//就是一个subtring中出现不同字母的次数，如果等于k了，判断数值大小
//如何得出不同的次数呢？用一个数值记录就行了
//不行啊，还是得用所有的数值减去重复的数值，这里有个小技巧就是用max函数来记录最多重复个数的值

class CharacterReplacement {
  public static int findLength(String str, int k) {
    int windowStart = 0;
    int maxRepeatCount = 0;
    int maxLength = 0;

    if(str == null || str.length() == 0 || k > str.length())
    	throw new IllegalArgumentException();

    Map<Character, Integer> subString = new HashMap<>();

    for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
    	char rightChar = str.CharAt(windowEnd);
    	subString.put(rightChar, subString.getOrDefault(rightChar, 0) + 1);
    	maxRepeatCount = Math.max(maxRepeatCount, subString.get(rightChar));
    	

    	if(windowEnd - windowStart + 1 - maxRepeatCount > k){
    		char leftChar = str.CharAt(windowStart);
    		subString.put(leftChar, subString.get(leftChar) - 1);
    		windowStart++;
    	}

    	maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

  	}

  	return maxLength;
  }
}
