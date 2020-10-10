import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class ReverseLevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    if(root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.push(root);
    while(queue.isEmpty()){
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for(int i = 0; i < levelSize; i++){
        TreeNode currentNode = queue.remove();
        currentLevel.add(currentNode.val);
        if(currentNode.left != null)
          queue.push(currentNode.left);
        if(currentNode.right != null)
          queue.push(currentNode.right);
      }
      result.add(0,currentLevel);
    }

    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}
