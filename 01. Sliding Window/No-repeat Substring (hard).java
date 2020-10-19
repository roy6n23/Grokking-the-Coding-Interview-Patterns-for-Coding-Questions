//利用滑动窗口
//注意substring一定要是连续的啊！！！
//临界条件：windowEnd往右滑，如果没有就put value =1，如果有的话就不记录数量，直接往右走，最后统计Map的size()
//得把str转化为arr，利用前面longest substring的方法
//因为是不重复的，所以如果右边的元素早就存在了我们就要跳到最右边元素的右边重新开始
import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
	int windowStart = 0;
	int maxLength = 0;

  	if(str == null || str.length() == 0)
  		throw new IllegalArgumentException();

  	Map<Character, Integer> noRepeatSubstring = new HashMap<>();

  	for( int windowEnd = 0; windowEnd < str.length(); windowEnd++){
  	  		char rightChar = str.CharAt(windowEnd);
  	
		  	if(noRepeatSubstring.containsKey(rightChar)){
		  		windowStart = noRepeatSubstring.get(rightChar) + 1;
		  	}

		  	noRepeatSubstring.put(rightChar, windowEnd);
		  	maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
		}
	return maxLength;
	}
}
