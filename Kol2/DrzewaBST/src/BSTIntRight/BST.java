package BSTIntRight;
class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
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

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
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

    void delete(int value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, int value) {
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
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
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
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.insert(-13);
        tree.insert(-46);
        tree.insert(-57);
        tree.insert(-21);
        tree.insert(-1);
        tree.insert(-11);
        tree.insert(-8);
        tree.insert(0);
        tree.insert(-1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(7);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

        System.out.println("\n\nDelete -3");
        tree.delete(-3);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

        System.out.println("\n\nDelete -13");
        tree.delete(-13);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

    }
}
