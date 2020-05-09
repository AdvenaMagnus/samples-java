package graphstrees;

import datatypes.tree.BinaryTreeNode;
import datatypes.tree.BinaryTreeUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by Alexander on 24.05.2017.
 */
public class BinaryTreeTest {

    BinaryTreeNode tree2level;
    BinaryTreeNode tree3level;
    BinaryTreeNode tree3levelUnbalanced;
    BinaryTreeNode searchTree3level;
    BinaryTreeNode NOTsearchTree3level; // example from book

    @Before
    public void initTrees(){
        tree2level = new BinaryTreeNode(2);
        tree2level.setLeft(new BinaryTreeNode(1));
        tree2level.setRight(new BinaryTreeNode(3));

        tree3level = new BinaryTreeNode(2);
        tree3level.setLeft(new BinaryTreeNode(1));
        tree3level.getLeft().setLeft(new BinaryTreeNode(3));
        tree3level.getLeft().setRight(new BinaryTreeNode(4));
        tree3level.setRight(new BinaryTreeNode(3));
        tree3level.getRight().setRight(new BinaryTreeNode(5));
        tree3level.getRight().setLeft(new BinaryTreeNode(6));

        tree3levelUnbalanced = new BinaryTreeNode(2);
        tree3levelUnbalanced.setLeft(new BinaryTreeNode(1));
        tree3levelUnbalanced.getLeft().setLeft(new BinaryTreeNode(3));
        tree3levelUnbalanced.getLeft().setRight(new BinaryTreeNode(4));
        tree3levelUnbalanced.setRight(new BinaryTreeNode(3));
        //tree3levelUnbalanced.getRight().setRight(new BinaryTreeNode(5));
        //tree3levelUnbalanced.getRight().setLeft(new BinaryTreeNode(6));

        searchTree3level = new BinaryTreeNode(4);
        searchTree3level.setLeft(new BinaryTreeNode(2));
        searchTree3level.getLeft().setLeft(new BinaryTreeNode(1));
        searchTree3level.getLeft().setRight(new BinaryTreeNode(3));
        searchTree3level.setRight(new BinaryTreeNode(6));
        searchTree3level.getRight().setRight(new BinaryTreeNode(7));
        searchTree3level.getRight().setLeft(new BinaryTreeNode(5));

        NOTsearchTree3level = new BinaryTreeNode(20);
        NOTsearchTree3level.setLeft(new BinaryTreeNode(10));
        NOTsearchTree3level.getLeft().setRight(new BinaryTreeNode(25));
        NOTsearchTree3level.setRight(new BinaryTreeNode(30));
    }

    @Test
    public void test2levelBalance(){
        assertTrue(BinaryTreeUtils.isBalanced(tree2level));
        assertTrue(BinaryTreeUtils.isBalanced(tree3level));
        assertFalse(BinaryTreeUtils.isBalanced(tree3levelUnbalanced));
    }

    @Test
    public void subnodesCountTest(){
        assertEquals(3, BinaryTreeUtils.subnodesCount(tree2level));
        assertEquals(7, BinaryTreeUtils.subnodesCount(tree3level));
    }

    @Test
    public void isBinaryTreeTest(){
        assertTrue(BinaryTreeUtils.isBinarySearchTree(tree2level, Integer.MAX_VALUE));
        assertTrue(BinaryTreeUtils.isBinarySearchTree(searchTree3level, Integer.MAX_VALUE));
        assertFalse(BinaryTreeUtils.isBinarySearchTree(tree3level, Integer.MAX_VALUE));
        assertFalse(BinaryTreeUtils.isBinarySearchTree(NOTsearchTree3level, Integer.MAX_VALUE));
    }

}
