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

public class BinaryTree {
    TreeNode root;
    
        BinaryTree() {
            root = null;
        }

        // Building the Binary Search Tree : Performing the insertion of the tree node
        public static void buildBST(TreeNode root, int data) {
            TreeNode treeNode = new TreeNode(data);
            //TreeNode currentTreeNode = root;

            if (root != null) {
                if (root.value <= data) {
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
                root = treeNode;
            }
        }

        // Printing the Binary Search Tree : Inorder Traversal of the Tree
        public static void inorderTraversal(TreeNode treeNode) {
            // TreeNode currentTreeNode = treeNode;
            if (treeNode != null) {
                if (treeNode.left != null) {
                    inorderTraversal(treeNode.left);
                } 
    
                System.out.print(treeNode.value + " ");
                
                if (treeNode.right != null) {
                    inorderTraversal(treeNode.right);
                }
            }
        }
    
        // main function : to declare new Binary Tree and perform various operations
        public static void main(String[] args) {
            BinaryTree bst = new BinaryTree();
            buildBST(bst.root, 4);
            buildBST(bst.root, 3);
            buildBST(bst.root, 2);
            buildBST(bst.root, 1);
            buildBST(bst.root, 5);
            buildBST(bst.root, 7);

            inorderTraversal(bst.root);
        }
}