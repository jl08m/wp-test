package com.jli.wp.patternmatch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jia on 4/23/2017.
 */
public class MyPatternTest {

    @Test
    public void testConstructor() {
        MyPattern pattern = new MyPattern("a,b,*");
        assertEquals("a,b,*", pattern.getPattern());
        assertEquals(3, pattern.getTokens().size());
        assertEquals("a", pattern.getTokens().get(0));
        assertEquals("b", pattern.getTokens().get(1));
        assertEquals(MyPattern.WILDCARD, pattern.getTokens().get(2));
    }
}

