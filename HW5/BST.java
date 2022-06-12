/* Title : BST class
 * Author : Ahmet Berkay SARIASLAN - Zülal KARIN
 * ID : 54490639066 - 12622989076
 * Section : 02
 * Assignment - 5
 * Description : This class of Binary class. 
 * We can store our data for BST in here.
 * We can use TreeCell for BST
 * Source :
 * 1-)www.geeksforgeeks.com
 * 2-)Algorithms 4th Edition(our book)
 */



class BST {

    static class TreeCell<T> {

        T data;
        TreeCell<T> left, right;

        public TreeCell(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    TreeCell<String> root;

    public BST() {
        root = null;
    }

    public void insert(String string) {
        root = insert(string, root);
    }

    private static TreeCell<String> insert(String string, TreeCell<String> node) {
        if (node == null) return new TreeCell<String>(string);
        int compare = string.compareTo(node.data);
        if (compare < 0) node.left = insert(string, node.left);
        else if (compare > 0) node.right = insert(string, node.right);
        return node;
    }

    public String show() {
        return show(root);
    }

    private static String show(TreeCell<String> node) {
        if (node == null) return "";
        return show(node.left) +
                node.data + " " +
                show(node.right);
    }
}