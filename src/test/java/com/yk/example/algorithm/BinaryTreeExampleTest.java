package com.yk.example.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yukui on 2016/9/8.
 */
public class BinaryTreeExampleTest {

    BinaryTreeExample.TreeNode tn1, tn2, tn3, tn4, tn5, tn6,tn7;

    /**
     *     1
     *    / \
     *   2   3
     *  / \   \
     * 4  5    6
     */
/*   @Before
    public void init1() {
        this.tn1 = new BinaryTreeExample.TreeNode(1);
        this.tn2 = new BinaryTreeExample.TreeNode(2);
        this.tn3 = new BinaryTreeExample.TreeNode(3);
        this.tn4 = new BinaryTreeExample.TreeNode(4);
        this.tn5 = new BinaryTreeExample.TreeNode(5);
        this.tn6 = new BinaryTreeExample.TreeNode(6);
        this.tn1.left = tn2;
        this.tn1.right = tn3;
        this.tn2.left = tn4;
        this.tn2.right = tn5;
        tn3.right = tn6;
    }*/

    /**
     *     1
     *    / \
     *   2   3
     *  / \  | \
     * 4  5  6  7
     */
    @Before
    public void init2() {
        this.tn1 = new BinaryTreeExample.TreeNode(1);
        this.tn2 = new BinaryTreeExample.TreeNode(2);
        this.tn3 = new BinaryTreeExample.TreeNode(3);
        this.tn4 = new BinaryTreeExample.TreeNode(4);
        this.tn5 = new BinaryTreeExample.TreeNode(5);
        this.tn6 = new BinaryTreeExample.TreeNode(6);
        this.tn7 = new BinaryTreeExample.TreeNode(7);
        this.tn1.left = tn2;
        this.tn1.right = tn3;
        this.tn2.left = tn4;
        this.tn2.right = tn5;
        this.tn3.left = tn6;
        tn3.right = tn7;
    }

    @Test
    public void getNodeNumRec() throws Exception {
        int num = BinaryTreeExample.getNodeNumRec(tn1);
        assertEquals(num,7);
    }

    @Test
    public void getDepthRec() throws Exception {
        assertEquals(BinaryTreeExample.getDepth(tn1),3);
    }

    @Test
    public void preorderTraversalRec() throws Exception {
        BinaryTreeExample.preorderTraversalRec(tn1);
    }

    @Test
    public void inorderTraversalRec() throws Exception {
        BinaryTreeExample.inorderTraversalRec(tn1);
    }

    @Test
    public void postorderTraversalRec() throws Exception {
       BinaryTreeExample.postorderTraversalRec(tn1);
    }

    @Test
    public void levelTraversalRec() throws Exception {
        BinaryTreeExample.levelTraversal(tn1);
    }

    @Test
    public void convertBST2DLLRec() throws Exception {
        BinaryTreeExample.TreeNode treeNode = BinaryTreeExample.convertBST2DLLRec(tn1);
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }

    @Test
    public void getNodeNumKthLevelRec() throws Exception {
        int num = BinaryTreeExample.getNodeNumKthLevelRec(tn1, 3);
        assertEquals(num,4);
    }

    @Test
    public void getNodeNumLeafRec() throws Exception {
        int num = BinaryTreeExample.getNodeNumLeafRec(tn1);
        assertEquals(num,4);
    }

    @Test
    public void isAVLRec() throws Exception {
        boolean avlRec = BinaryTreeExample.isAVLRec(tn3);
        assertEquals(avlRec,true);
    }

    @Test
    public void isSameRec() throws Exception {
        boolean sameRec = BinaryTreeExample.isSameRec(tn1, tn1);
        assertEquals(sameRec ,true);
    }

    @Test
    public void mirrorRec() throws Exception {

    }

    @Test
    public void mirrorCopyRec() throws Exception {

    }

    @Test
    public void isMirrorRec() throws Exception {

    }

    @Test
    public void getLastCommonParentRec() throws Exception {

    }

    @Test
    public void isCompleteBinaryTreeRec() throws Exception {

    }

    @Test
    public void isPerfectBinaryTreeRec() throws Exception {

    }

    @Test
    public void isCompleteBinaryTreeSubRec() throws Exception {

    }

}