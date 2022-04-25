package DataStructureWithMosh.Trees.BinaryTrees;

public class Tree {

    Node root;

    private class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public void insert(int value){
        Node node = new Node(value);
        if(root == null){
            root = node;
            root.left = null;
            root.right = null;
        }else{
            var current = root;
            while (true){
                if(current.value > value){
                    if(current.left==null) {
                        current.left = node;
                        break;
                    }
                    current = current.left;
                }else {
                    if(current.right == null) {
                        current.right = node;
                        break;
                    }
                    current = current.right;
                }
            }

        }
    }
    public boolean find(int value){
        var current = root;
        while (current!=null){
            if(current.value == value){
                return true;
            }
            if(current.value < value){
                current = current.right;
            }else{
                current = current.left;
            }
        }
        return false;
    }

    public void preOrderTraversal(){
        System.out.println("This is Pre_orderTraversal");
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root){
        if(root==null)
            return;
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private void inOrderTraversal(Node root){
        if(root==null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }
    public void inOrderTraversal(){
        System.out.println("This is in order traversal");
        inOrderTraversal(root);
    }

    public void postOrderTraversal(){
        System.out.println("This is post order");
        postOrderTraversal(root);
    }

    public void postOrderTraversal(Node root){
        if (root==null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }

    public boolean equals(Tree tree1){
        return equals(root , tree1.root);
    }
    public boolean equals(Node first , Node second){
        if(first == null && second == null)
            return true;
        if(first !=null && second!=null){
            return first.value == second.value&&
                    equals(first.left , second.left)&& equals(first.right , second.right);
        }
        return false;
    }

    public int height(){
        return height(root);
    }

    public int height(Node root){

        if(root.left == null && root.right == null)
            return 0;
        return 1+Math.max(
                height(root.left),
                height(root.right));
    }

}

class Main{
    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree tree1 = new Tree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(25);
        tree.insert(5);
        tree.insert(15);
        tree.insert(18);
        System.out.println();
        tree1.insert(10);
        tree1.insert(20);
        tree1.insert(30);
        tree1.insert(25);
        tree1.insert(5);
        tree1.insert(15);
        tree1.insert(18);



//        System.out.println(tree.find(25));
//        tree.preOrderTraversal();
//        System.out.println();
//        tree.inOrderTraversal();
//        System.out.println();
//        tree.postOrderTraversal();
//        System.out.println();
//        System.out.println(tree.height());
    }

}
