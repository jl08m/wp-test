package com.jli.wp.patternmatch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jia on 4/23/2017.
 */
public class MyPathTest {

    @Test
    public void testConstructor() {
        MyPath path = new MyPath("a/b");
        assertEquals("a/b", path.getPath());
        assertEquals(2, path.getTokens().size());
        assertEquals("a", path.getTokens().get(0));
        assertEquals("b", path.getTokens().get(1));
    }
}

