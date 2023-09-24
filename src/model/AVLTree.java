package model;

public class AVLTree {

    private TreeNode root;
    private Book book;

    public AVLTree() {
        root = null;
        book = new Book();
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.getLeft();
        TreeNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }

    private TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.getRight();
        TreeNode T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    public void insert(Book book) {
        root = insertRecursive(root, book);
    }

    private TreeNode insertRecursive(TreeNode root, Book book) {
        if (root == null) {
            return new TreeNode(book);
        }

        if (book.getCodeISBN().compareTo(root.getData().getCodeISBN()) < 0) {
            root.setLeft(insertRecursive(root.getLeft(), book));
        } else if (book.getCodeISBN().compareTo(root.getData().getCodeISBN()) > 0) {
            root.setRight(insertRecursive(root.getRight(), book));
        } else {
            return root;
        }

        root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight())));

        int balance = getBalance(root);

        if (balance > 1 && book.getCodeISBN().compareTo(root.getLeft().getData().getCodeISBN()) < 0) {
            return rightRotate(root);
        }

        if (balance < -1 && book.getCodeISBN().compareTo(root.getRight().getData().getCodeISBN()) > 0) {
            return leftRotate(root);
        }

        if (balance > 1 && book.getCodeISBN().compareTo(root.getLeft().getData().getCodeISBN()) > 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        if (balance < -1 && book.getCodeISBN().compareTo(root.getRight().getData().getCodeISBN()) < 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }
        book.setNumberBooks(+1);
        return root;
    }

    public void delete(String codeISBN) {
        root = deleteRecursive(root, codeISBN);
    }

    private TreeNode deleteRecursive(TreeNode root, String codeISBN) {
        if (root == null) {
            return root;
        }

        if (codeISBN.compareTo(root.getData().getCodeISBN()) < 0) {
            root.setLeft(deleteRecursive(root.getLeft(), codeISBN));
        } else if (codeISBN.compareTo(root.getData().getCodeISBN()) > 0) {
            root.setRight(deleteRecursive(root.getRight(), codeISBN));
        } else {
            if (root.getLeft() == null || root.getRight() == null) {
                TreeNode temp = root.getLeft() != null ? root.getLeft() : root.getRight();
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                TreeNode temp = minValueNode(root.getRight());
                root.getData().setCodeISBN(temp.getData().getCodeISBN());
                root.setRight(deleteRecursive(root.getRight(), temp.getData().getCodeISBN()));
            }
        }

        if (root == null) {
            return root;
        }

        root.setHeight(1 + Math.max(height(root.getLeft()), height(root.getRight())));

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.getLeft()) >= 0) {
            return rightRotate(root);
        }

        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.getRight()) <= 0) {
            return leftRotate(root);
        }

        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }
    public Book searchByName(TreeNode node, String tittle) {
    if (node == null) {
        return null; // El árbol está vacío o el nombre no se encontró
    }

    Book book = node.getData();

    if (book.getTitle().equals(tittle)) {
        return book; 
    } else if (tittle.compareTo(book.getTitle()) < 0) {
        return searchByName(node.getLeft(), tittle);
    } else {
        return searchByName(node.getRight(), tittle);
    }
}

public Book searchByName(String name) {
    return searchByName(root, name);
}


    private TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public TreeNode getRoot() {
        return root;
    }
    
}
