//--------------------BRUTE FORCE----------------
//--------------------BRUTE FORCE----------------
//--------------------BRUTE FORCE----------------
//--------------------BRUTE FORCE----------------
//--------------------BRUTE FORCE----------------
//--------------------BRUTE FORCE----------------
//--------------------BRUTE FORCE----------------
//--------------------BRUTE FORCE----------------



class PartitionSet {

  public boolean canPartition(int[] num) {
    int sum = 0;
    for (int i = 0; i < num.length; i++)
      sum += num[i];

    // if 'sum' is a an odd number, we can't have two subsets with equal sum
    if(sum % 2 != 0)
      return false;

    return this.canPartitionRecursive(num, sum/2, 0);
  }

  private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
    // base check
    if (sum == 0)
      return true;

    if(num.length == 0 || currentIndex >= num.length)
      return false;

    // recursive call after choosing the number at the currentIndex
    // if the number at currentIndex exceeds the sum, we shouldn't process this
    if( num[currentIndex] <= sum ) {
      if(canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
        return true;
    }

    // recursive call after excluding the number at the currentIndex
    return canPartitionRecursive(num, sum, currentIndex + 1);
  }
}

 //------------------------TOP-DOWN-----------------------
 //------------------------TOP-DOWN-----------------------
 //------------------------TOP-DOWN------------------------
 //------------------------TOP-DOWN------------------------
 //------------------------TOP-DOWN------------------------
 //------------------------TOP-DOWN------------------------


class PartitionSet {

  public boolean canPartition(int[] num) {
    int sum = 0;
    for (int i = 0; i < num.length; i++)
      sum += num[i];

    // if 'sum' is a an odd number, we can't have two subsets with equal sum
    if (sum % 2 != 0)
      return false;

    Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
    return this.canPartitionRecursive(dp, num, sum / 2, 0);
  }

  private boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
    // base check
    if (sum == 0)
      return true;

    if (num.length == 0 || currentIndex >= num.length)
      return false;

    // if we have not already processed a similar problem
    if (dp[currentIndex][sum] == null) {
      // recursive call after choosing the number at the currentIndex
      // if the number at currentIndex exceeds the sum, we shouldn't process this
      if (num[currentIndex] <= sum) {
        if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
          dp[currentIndex][sum] = true;
          return true;
        }
      }

      // recursive call after excluding the number at the currentIndex
      dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
    }

    return dp[currentIndex][sum];
  }

}



//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------
//----------------------------------BOTTOM-UP----------------------------------


class PartitionSet {

  public boolean canPartition(int[] num) {
    int n = num.length;
    // find the total sum
    int sum = 0;
    for (int i = 0; i < n; i++)
      sum += num[i];

    // if 'sum' is a an odd number, we can't have two subsets with same total
    if(sum % 2 != 0)
      return false;

    // we are trying to find a subset of given numbers that has a total sum of ‘sum/2’.
    sum /= 2;

    boolean[][] dp = new boolean[n][sum + 1];

    // populate the sum=0 columns, as we can always for '0' sum with an empty set
    for(int i=0; i < n; i++)
      dp[i][0] = true;

    // with only one number, we can form a subset only when the required sum is equal to its value
    for(int s=1; s <= sum ; s++) {
      dp[0][s] = (num[0] == s ? true : false);
    }

    // process all subsets for all sums
    for(int i=1; i < n; i++) {
      for(int s=1; s <= sum; s++) {
        // if we can get the sum 's' without the number at index 'i'
        if(dp[i-1][s]) {
          dp[i][s] = dp[i-1][s];
        } else if (s >= num[i]) { // else if we can find a subset to get the remaining sum
          dp[i][s] = dp[i-1][s-num[i]];
        }
      }
    }

    // the bottom-right corner will have our answer.
    return dp[n-1][sum];
  }

}