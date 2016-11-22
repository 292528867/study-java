package com.yk.example.java8;

import org.junit.Test;

/**
 * Created by yukui on 2016/11/21.
 */
public class StreamsExampleTest {
    @Test
    public void testStreams() throws Exception {
        StreamsExample.testFilter();
    }

    @Test
    public void testMap() throws Exception {
        StreamsExample.testMap();
    }


    @Test
    public void testCount() throws Exception {
        StreamsExample.testCount();
    }

    @Test
    public void testReduce() throws Exception {
        StreamsExample.testReduce();
    }

    @Test
    public void testParallel() throws Exception {
        StreamsExample.testParallel();
    }

    @Test
    public void test() throws Exception {
        StreamsExample.test();
    }
}