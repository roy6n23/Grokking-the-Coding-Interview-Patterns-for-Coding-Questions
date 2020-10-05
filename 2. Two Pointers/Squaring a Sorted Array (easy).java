class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int n = arr.length;
    int[] squares = new int[n];
    int highestSquareInx = n - 1;
    int left = 0, right = n - 1;
    while(left <= right){
    	int leftSquare = arr[left]^2;
    	int rightSquare = arr[right]^2;
    	if(leftSquare < rightSquare){
    		squares[highestSquareInx--] = rightSquare;
    		right--;
    	} else{
    		squares[highestSquareInx--] = leftSquare;
    		left++;
    	}
    }
    return squares;
  }

  public static void main(String[] args) {

    int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();
  }
}
