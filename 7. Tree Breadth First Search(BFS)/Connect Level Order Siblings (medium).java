import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }

  // level order traversal using 'next' pointer
  public void printLevelOrder() {
    TreeNode nextLevelRoot = this;
    while (nextLevelRoot != null) {
      TreeNode current = nextLevelRoot;
      nextLevelRoot = null;
      while (current != null) {
        System.out.print(current.val + " ");
        if (nextLevelRoot == null) {
          if (current.left != null)
            nextLevelRoot = current.left;
          else if (current.right != null)
            nextLevelRoot = current.right;
        }
        current = current.next;
      }
      System.out.println();
    }
  }
};

class ConnectLevelOrderSiblings {
  public static void connect(TreeNode root) {
    if (root == null)
      return;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode previousNode = null;
      int levelSize = queue.size();
      // connect all nodes of this level
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        if (previousNode != null)
          previousNode.next = currentNode;
        previousNode = currentNode;

        // insert the children of current node in the queue
        if (currentNode.left != null)
          queue.offer(currentNode.left);
        if (currentNode.right != null)
          queue.offer(currentNode.right);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectLevelOrderSiblings.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }
}
