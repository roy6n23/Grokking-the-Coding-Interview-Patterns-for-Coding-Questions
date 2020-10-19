import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class LevelAverage {
  public static List<Double> findLevelAverages(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if(root == null)
      return result;

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int max_value = Integer.MIN_VALUE;
      int levelSize = queue.size();
      for(int i = 0; i< levelSize; i++){
        TreeNode currentNode = queue.poll();
        max_value = Math.max(currentNode.val, max_value);
        
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
    result.add(max_value);

    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<Double> result = LevelAverage.findLevelAverages(root);
    System.out.print("Level averages are: " + result);
  }
}
