import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// TreeNode : in order to make Binary Search Tree
class TreeNode {
    int value;
    TreeNode left, right;

    // constructor
    public TreeNode(int data) {
        value = data;
        left = null;
        right = null;
    }
}

// Binary Search Tree
public class BinarySearchTree {
    TreeNode root;
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    
        BinarySearchTree(int val) {
            root = new TreeNode(val);
        }

        // Building the Binary Search Tree : Performing the insertion of the tree node
        public static void buildBST(TreeNode root, int data) {
            TreeNode treeNode = new TreeNode(data);

            if (root != null) {
                if (root.value >= data) {
                    if (root.left == null) {
                        root.left = treeNode;
                    } else {
                        buildBST(root.left, data);
                    }
                } else {
                    if (root.right == null) {
                        root.right = treeNode;
                    } else {
                        buildBST(root.right, data);
                    }
                }
            } else {
                System.out.println("Tree has no root");
            }
        }

        // Printing the Binary Search Tree : Inorder Traversal of the Tree
        // Printing the BST node values in Increasing Order
        // left --> root --> right 
        public static void inorderTraversal(TreeNode treeNode) {
            // TreeNode currentTreeNode = treeNode;
            if (treeNode != null) {
                if (treeNode.left != null) {
                    inorderTraversal(treeNode.left);
                } 
                System.out.println(treeNode.value);
                if (treeNode.right != null) {
                    inorderTraversal(treeNode.right);
                }
            }
        }

        // Preorder Traversal of the Binary Search Tree
        // root --> left --> right 
        public static void preorderTraversal(TreeNode treeNode) {
            if (treeNode != null) {
                System.out.println(treeNode.value);
                if (treeNode.left != null) {
                    preorderTraversal(treeNode.left);
                }
                if (treeNode.right != null) {
                    preorderTraversal(treeNode.right);
                }
            }
        }

        // Postorder Traversal of the Bianry Search Tree
        // left --> right --> root
        public static void postorderTraversal(TreeNode treeNode) {
            if (treeNode != null) {
                if (treeNode.left != null) {
                    postorderTraversal(treeNode.left);
                }
                if (treeNode.right != null) {
                    postorderTraversal(treeNode.right);
                }
                System.out.println(treeNode.value);
            }
        }

        // Printing the BST node values in Decreasing Order
        // right --> root --> left
        public static void printDecreasingOrder(TreeNode treeNode) {
            if (treeNode != null) {
                if (treeNode.right != null) {
                    printDecreasingOrder(treeNode.right);
                }
                System.out.println(treeNode.value);
                if (treeNode.left != null) {
                    printDecreasingOrder(treeNode.left);
                }
            }
        }
    
        // Breadth First Traversal or Level Order Traversal
        public static void breadthFirstTraversal(TreeNode treeNode) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            if (treeNode == null) return;
            queue.add(treeNode);
            while (!queue.isEmpty()) {
                TreeNode tempNode = queue.remove();
                System.out.println(tempNode.value);
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }

        // main function : to declare new Binary Tree and perform various operations
        public static void main(String[] args) {
            BinarySearchTree bst = new BinarySearchTree(4);
            buildBST(bst.root, 3);
            buildBST(bst.root, 2);
            buildBST(bst.root, 1);
            buildBST(bst.root, 5);
            buildBST(bst.root, 6);
            buildBST(bst.root, 7);
            buildBST(bst.root, 0);
            buildBST(bst.root, 11);
            buildBST(bst.root, 12);

            inorderTraversal(bst.root);
            System.out.println();
            //preorderTraversal(bst.root);
            //printDecreasingOrder(bst.root);
            breadthFirstTraversal(bst.root);
        }
}

