package model;

public class TreeNode {
    private Book data;
    private TreeNode left;
    private TreeNode right;
    private int height;

    public TreeNode(Book data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1; // Inicialmente, la altura del nodo es 1.
    }

    public Book getData() {
        return data;
    }

    public void setData(Book data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
