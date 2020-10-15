class Solution {
  public static int[][] flipAndInvertImage(int[][] arr) {
      int C = arr[0].length;
      for (int[] row: arr) {
          for (int i = 0; i < (C + 1) / 2; ++i) {
              int tmp = row[i] ^ 1;
              row[i] = row[C - 1 - i] ^ 1;
              row[C - 1 - i] = tmp;
          }
      }
      return arr;
  }

  public static void print(int[][] arr) {
    for(int i=0; i < arr.length; i++) {
      for (int j=0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
    print(flipAndInvertImage(arr));
    System.out.println();

    int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
    print(flipAndInvertImage(arr2));
  }
}