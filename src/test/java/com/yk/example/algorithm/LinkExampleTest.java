package com.yk.example.algorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by yukui on 2016/9/8.
 */
public class LinkExampleTest {

    LinkExample.Node node1,node2,node3,node4, node5;

    @Before
    public void init() {
        this.node1 = new LinkExample.Node(1);
        this.node2 = new LinkExample.Node(2);
        this.node3 = new LinkExample.Node(3);
        this.node4 = new LinkExample.Node(4);
        this.node5 = new LinkExample.Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    @Test
    public void printList() throws Exception {
        LinkExample.printList(node1);
    }

    @Test
    public void getListLengthTest() throws Exception {
        System.out.println(LinkExample.getListLength(node1));
    }

    @Test
    public void reverseListTest() throws Exception {
        LinkExample.Node reNode = LinkExample.reverseList(node1);
        LinkExample.printList(reNode);
    }

    @Test
    public void reGetKthNodeTest() throws Exception {
        LinkExample.Node node = LinkExample.reGetKthNode(node1, 3);
        LinkExample.printList(node);
    }

    @Test
    public void reGetKthNodeRecTest() throws Exception {
        LinkExample.reGetKthNodeRec(node1,3);
    }
}