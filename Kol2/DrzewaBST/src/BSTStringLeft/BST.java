package BSTStringLeft;
class Node {
    String value;
    Node left;
    Node right;

    Node(String value) {
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

    void insert(String value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, String value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    void delete(String value) {
        root = deleteRec(root, value);
    }

    Node deleteRec(Node root, String value) {
        if (root == null) {
            return root;
        }

        if (value.compareTo(root.value) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
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

    String maxValue(Node root) {
        String maxValue = root.value;
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
              "mango"
           /          \
       "apple"       "peach"
         /   \         /    \
    "apricot" "banana" "pear" "plum" */
        tree.insert("trem");
        tree.insert("funkcja");
        tree.insert("drzewo");
        tree.insert("formuła");
        tree.insert("refutacja");
        tree.insert("klauzula");
        tree.insert("model");
        tree.insert("zmienna");
        tree.insert("unifikacja");

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

        System.out.println("\n\nDelete 'trem'");
        tree.delete("trem");
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();

        System.out.println("\n\nDelete 'funkcja'");
        tree.delete("funkcja");
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nTree structure:");
        tree.printTree();
    }
}
