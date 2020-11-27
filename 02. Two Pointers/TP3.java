class SortSquare{
	public static int[] makeSquare(int[] arr){
		int left = 0, right = arr.length -1;
		int[] result = new int[arr.length];
		int hightestIndex = arr.length-1;

		while(left < right){
			int leftSquare = arr[left] * arr[left];
			int rightSquare = arr[right] * arr[right];

			if(leftSquare > rightSquare){
				result[hightestIndex--] = arr[leftSquare];
				left++;
			}else{
				result[hightestIndex--] = arr[rightSquare];
				right--;
			}
		}
		return result;
	}
}