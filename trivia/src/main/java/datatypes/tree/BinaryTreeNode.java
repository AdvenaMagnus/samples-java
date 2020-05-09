package datatypes.tree;

/**
 * Created by Alexander on 24.05.2017.
 */
public class BinaryTreeNode {

    public BinaryTreeNode(){
    }

    public BinaryTreeNode(int value){
        this.intValue = value;
    }

    int intValue;
    String name;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public int getIntValue() {
        return intValue;
    }
    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }
    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }
    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
