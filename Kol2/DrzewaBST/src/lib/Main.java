package lib;

public class Main {
    public static void main(String[] args) {
        TreeBST<Integer> treeBST = new TreeBST<>();
        treeBST.insert(-13);
        treeBST.insert(-46);
        treeBST.insert(-57);
        treeBST.insert(-21);
        treeBST.insert(-3);
        treeBST.insert(-11);
        treeBST.insert(-8);
        treeBST.insert(0);
        treeBST.insert(-1);
        treeBST.insert(5);
        treeBST.insert(4);
        treeBST.insert(7);
        System.out.println(treeBST.countSingleSubtree());
        System.out.print("Inorder: ");treeBST.inorder();
        System.out.println();
        System.out.print("Postorder: ");treeBST.postorder();
    }
}
