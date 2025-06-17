import java.awt.Color;

public class RubroNegra {

    private void leftRotate (Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;
    
        y.parent = x.parent;
    
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
    
        y.left = x;
        x.parent = y;
    }

    private void rightRotate (Node y) {
        Node x = y.right;
        y.left = x.right;
        if (x.right != NIL) x.right.parent = x;
    
        x.parent = y.parent;
    
        if (y.parent == null) root = x;
        else if (y == y.parent.right) y.parent.right = x;
        else y.parent.left = x;
    
        x.right = y;
        y.parent = x;
    }

    public void insert (int key) {
        Node node = new Node(key);
        node.left = node.right = node.parent = NIL;

        Node y = null;
        Node x = null;

        while (x != NIL) {
            y = x;
            if (node.key < x.key) x = x.left;
            else x = x.right;
        }

        node.parent = y;
        if (y  == null) root = node;
        else if (node.key < y.key) y.left = node;
        else y.right = node;

        node.left = NIL;
        node.right = NIL;
        node.color = color.RED;

        insertFix(node);
    }

    public void insertFix(Node k) {
        while (k.parent != null && k.parent.color == Color.RED) {
            if (k.parent == k.parent.parent.left) {
                Node u = k.parent.parent.right;
                if (u.color == Color.RED) {
                    k.parent.color = Color.BLACK;
                    u.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    rightRotate(k.parent.parent);
                }
            } else {
                Node u = k.parent.parent.left;
                if (u.color == Color.RED) {
                    k.parent.color = Color.BLACK;
                    u.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.color = Color.RED;
                }
            }
        }
    }

    public void transplante (Node u, Node v) {
        if (u.parent == null) root = v;
        else if (u == u.parent.left) u.parent.left = v;
        else u.parent.right = v;
        v.parent = u.parent;
    }

    private Node minimum (Node node) {
        while (node.left != NIL) node = node.left;
        return node;
    }

    private void delete (int key) {
        Node z = searchTree(root, key);
        if (z == NIL) return;

        Node y = z;
        Color yOriginalColor = y.color;
        Node x;

        if (z.left == NIL) {
            x = z.right;
            transplante(z, z.right);
        } else if (z.right == NIl) {
            x = z.left;
            transplante(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) x.parent = y;
            else {
                transplante(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplante(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == Color.BLACK) deleteFix(x);
    }

    public void deleteFix (Node x) {
        Node w;
        while (x != root && x.color == Color.BLACK) {
            if (x == x.parent.left) {
                w = x.parent.right;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    leftRotate(x.parent);
                    w = x.parent.right; 
                }
                if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                } else {
                    if (w.right.color == Color.BLACK) {
                        w.left.color = Color.BLACK;
                        w.color = Color.RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.right.color = Color.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            } else {
                w = x.parent.left;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == Color.BLACK && w.left.color == Color.Black) {
                    w.color = Color.RED;
                    x = x.parent;
                } else {
                    if ( w.left.color == Color.BLACK) {
                        w.right.color = Color.BLACK;
                        w.color = Color.RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.left.color = Color.BLACK;
                    rightRotate(x.parent);
                    x.root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    private Node searchTree (Node node, int key) {
        if (node == NIL || key  == node.key) return node;
        if (key <  node.key) return searchTree(node.left, key)
        return searchTree(node.right, key)
    }

    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    public void inorderHelper (Node node) {
        if (node != NIL) {
            inorderHelper(node.left);
            String colorSuffix = (node.color == Color.RED) ? "R" : "B";
            System.out.println(node.key + colorSuffix + " ");
            inorderHelper(node.right);
        }
    }
}
