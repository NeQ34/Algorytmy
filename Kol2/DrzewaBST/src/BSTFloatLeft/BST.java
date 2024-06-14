package BSTFloatLeft;

class Node {
    float value;
    Node left;
    Node right;

    Node(float value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class BST {
    Node root;

    BST() {
        root = null;
    }

    void insert(float value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, float value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    void delete(float value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, float value) {
        if (root == null) {
            return root;
        }

        if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node to be deleted found

            // Case 1: Node has no children (is a leaf)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            root.value = maxValue(root.left);
            root.left = deleteRec(root.left, root.value);
        }

        return root;
    }

    float maxValue(Node root) {
        float maxValue = root.value;
        while (root.right != null) {
            maxValue = root.right.value;
            root = root.right;
        }
        return maxValue;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    void printTree() {
        printTreeRec(root, "", true);
    }

    void printTreeRec(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);
            printTreeRec(node.left, prefix + (isTail ? "    " : "│   "), false);
            printTreeRec(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();

        /* Let us create following BST
              50.5
           /      \
        30.3     70.7
        /  \     /   \
      20.2 40.4 60.6  80.8 */
        tree.insert(50.5f);
        tree.insert(30.3f);
        tree.insert(20.2f);
        tree.insert(40.4f);
        tree.insert(70.7f);
        tree.insert(60.6f);
        tree.insert(80.8f);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

        System.out.println("\n\nDelete 20.2");
        tree.delete(20.2f);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

        System.out.println("\n\nDelete 30.3");
        tree.delete(30.3f);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

        System.out.println("\n\nDelete 50.5");
        tree.delete(50.5f);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();
    }
}

