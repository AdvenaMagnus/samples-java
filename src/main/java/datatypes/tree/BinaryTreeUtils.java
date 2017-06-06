package datatypes.tree;

/**
 * Created by Alexander on 24.05.2017.
 */
public class BinaryTreeUtils {

    public static boolean isBalanced(BinaryTreeNode btnRoot){
        if(btnRoot.getLeft()==null && btnRoot.getRight()==null) return true;

        int leftNodes = subnodesCount(btnRoot.getLeft());
        int rightNodes = subnodesCount(btnRoot.getRight());

        if(leftNodes==rightNodes || leftNodes-rightNodes == -1 || leftNodes-rightNodes == 1) return true;

        return false;
    }

    public static boolean isHasChildren(BinaryTreeNode btnRoot){
        if(btnRoot.getRight()!=null || btnRoot.getLeft()!=null) return true;
        return false;
    }

    public static int childrenCount(BinaryTreeNode btnRoot){
        int result = 0;
        if(btnRoot.getLeft()!=null)result++;
        if(btnRoot.getRight()!=null)result++;
        return result;
    }

    public static int subnodesCount(BinaryTreeNode btnRoot){
        if(btnRoot!=null) {
            int result = 1;
            if (btnRoot.getLeft() != null) {
                result = result + subnodesCount(btnRoot.getLeft());
            }
            if (btnRoot.getRight() != null) {
                result = result + subnodesCount(btnRoot.getRight());
            }
            return result;
        }
        return 0;
    }

    public static boolean isBinarySearchTree(BinaryTreeNode btnRoot, int max){
        boolean isBinary = checkForBinarySearch(btnRoot, max);
        if(isBinary){
            if(btnRoot.getLeft()!=null) isBinary = isBinarySearchTree(btnRoot.getLeft(), btnRoot.getIntValue());
            if(isBinary)
                if(btnRoot.getRight()!=null) isBinary = isBinarySearchTree(btnRoot.getRight(), Integer.MAX_VALUE);
        }
        return isBinary;
    }

    public static boolean checkForBinarySearch(BinaryTreeNode btnRoot, int max){
        if(btnRoot.getLeft()==null && btnRoot.getRight()!=null){
            if(btnRoot.getIntValue() <= btnRoot.getRight().getIntValue() && btnRoot.getRight().getIntValue()<max)return true;
            else return false;
        }
        if(btnRoot.getLeft()!=null && btnRoot.getRight()==null){
            if(btnRoot.getIntValue() > btnRoot.getLeft().getIntValue())return true;
            else return false;
        }
        if(btnRoot.getLeft()!=null && btnRoot.getRight()!=null){
            if(btnRoot.getIntValue() > btnRoot.getLeft().getIntValue() && btnRoot.getIntValue() <= btnRoot.getRight().getIntValue() && btnRoot.getRight().getIntValue()<max) return true;
            return false;
        }
        return true;
    }

}
