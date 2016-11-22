package com.yk.example.algorithm;

/**
 * 二叉查找树(bst)又称二叉排序树
 * 或者是一颗空树，或者是具有下列性质的二叉树：
 * 1.若它的左子树不为空，左子树上所有的节点的值均小于它的根节点
 * 2.若它的右子树不为空，右子树上所有的节点的值均大于它的根节点
 * 3.它的左子树，右子树也为二叉查找树
 * Created by yukui on 2016/9/8.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    static class BinaryNode<T> {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode() {
        }

        public BinaryNode(T data) {
            this(data, null, null);
        }

        public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private  BinaryNode<T> rootTree;

    /**
     * 构造一颗空的二叉查找树
     */
    public BinarySearchTree() {
        rootTree = null;
    }

    /**
     * 清空二叉查找树
     */
    public  void clear() {
        rootTree = null;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rootTree == null;
    }

    /**
     * 从根结点出开始查找元素
     *
     * @param t
     * @return
     */
    public boolean contains(T t) {
        return contains(t, rootTree);
    }

    /**
     * 从某个结点出开始查找元素
     *
     * @param t
     * @param node
     * @return
     */
    public boolean contains(T t, BinaryNode<T> node) {
        if (node == null) {
            return false;//结点为空，查找失败
        }
        int result = t.compareTo(node.data);
        if (result > 0) {
            return contains(t, node.right);//递归查询右子树
        }
        if (result < 0) {
            return contains(t, node.left); ////递归查询左子树
        }
        return true;
    }

    /**
     * 找到二叉查找树中的最小值
     *
     * @return
     */
    public T findMin() {
        if (isEmpty()) {
            return null;
        }
        return findMin(rootTree).data;
    }

    /**
     * 查询出最小元素所在的结点
     */
    public BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null)
            return null;
        else if (node.left == null)
            return node;
        return findMin(node.left);//递归查找
    }

    public  T findMax() {
        if (isEmpty()) {
            return null;
        }
        return findMax(rootTree).data;
    }

    /**
     * 查询出最大元素所在的结点
     */
    public BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node != null) {
            while (node.right != null)
                node = node.right;
        }
        return node;
    }

    /**
     * 在某个位置开始判断插入元素
     */
    public BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null) {
            //新构造一个二叉查找树
            return new BinaryNode<T>(t, null, null);
        }
        int result = t.compareTo(node.data);
        if (result < 0)
            node.left = insert(t, node.left);
        else if (result > 0)
            node.right = insert(t, node.right);
        else
            ;//doNothing
        return node;
    }

    /**
     * 在某个位置开始判断删除某个结点
     */
    public BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null)
            return node;//没有找到,doNothing
        int result = t.compareTo(node.data);
        if (result > 0)
            node.right = remove(t, node.right);
        else if (result < 0)
            node.left = remove(t, node.left);
        else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = remove(node.data, node.right);
        } else
            node = (node.left != null) ? node.left : node.right;
        return node;

    }

    public BinaryNode<Integer> init() {
        BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);
        BinaryNode<Integer> node1 = new BinaryNode<Integer>(1);
        BinaryNode<Integer> node4 = new BinaryNode<Integer>(4, node3, null);
        BinaryNode<Integer> node2 = new BinaryNode<Integer>(2, node1, node4);
        BinaryNode<Integer> node8 = new BinaryNode<Integer>(8);
        BinaryNode<Integer> root = new BinaryNode<Integer>(6, node2, node8);
        return root;
    }
    
  
    public static void preOrder(BinaryNode node) {
        if (node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
