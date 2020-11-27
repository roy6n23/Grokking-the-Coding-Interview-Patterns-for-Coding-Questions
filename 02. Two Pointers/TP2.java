class RemoveDuplicates{
	public static int remove(int[] arr){
		// index of the next non-duplicate element
		int nextNonDuplicate = 1;
		for(int i = 1; i < arr.length; i++){
			if(arr[nextNonDuplicate - 1] != arr[i]){
				arr[nextNonDuplicate] = arr[i];
				nextNonDuplicate++;
			}
		}

		return nextNonDuplicate;
	}
}


//===============================similar question

class RemoveElement{
	public static int remove(int[] arr, int key){
		int nextElment = 0;
		for(int i = 0; i <arr.length; i++){
			if(arr[i] != key){
				arr[nextElment] = arr[i];
				nextElment++;
			}
		}
		return nextElment;
	}
}