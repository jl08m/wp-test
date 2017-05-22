package com.jli.wp.patternmatch;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by Jia on 4/23/2017.
 */
public class PatternMatcherTest {

    @Test
    public void testMatch_noMatch() {
        String result = PatternMatcher.match(
                Collections.singletonList(new MyPattern("foo")),
                new MyPath("bar")
                );
        assertEquals(PatternMatcher.NO_MATCH, result);
    }

    @Test
    public void testMatch_singlePatternMatch() {
        String result = PatternMatcher.match(
                Collections.singletonList(
                        new MyPattern("foo")
                ),
                new MyPath("foo"));
        assertEquals("foo", result);
    }

    @Test
    public void testMatch_twoPatternMatch() {
        String result = PatternMatcher.match(
                Arrays.asList(
                        new MyPattern("a,b"),
                        new MyPattern("x,y")
                ),
                new MyPath("a/b"));
        assertEquals("a,b", result);
    }

    @Test
    public void testMatch_multiPatternMatch() {
        String result = PatternMatcher.match(
                Arrays.asList(
                        new MyPattern("1,2"),
                        new MyPattern("foo,bar"),
                        new MyPattern("a,b"),
                        new MyPattern("x,y")
                ),
                new MyPath("a/b"));
        assertEquals("a,b", result);
    }

    @Test
    public void testMatch_multiPatternNoMatch() {
        String result = PatternMatcher.match(
                Arrays.asList(
                        new MyPattern("m,n"),
                        new MyPattern("x,y")
                ),
                new MyPath("a/b"));
        assertEquals(PatternMatcher.NO_MATCH, result);
    }

    @Test
    public void testMatch_singleWildcardMatch() {
        String result = PatternMatcher.match(
                Collections.singletonList(
                        new MyPattern("*,b")
                ),
                new MyPath("a/b"));
        assertEquals("*,b", result);
    }

    @Test
    public void testMatch_multipleWildcardMatch() {
        String result = PatternMatcher.match(
                Collections.singletonList(
                        new MyPattern("*,b,*")
                ),
                new MyPath("a/b/c"));
        assertEquals("*,b,*", result);
    }

    @Test
    public void testMatch_rankWildcardMatch() {
        String result = PatternMatcher.match(
                Arrays.asList(
                        new MyPattern("a,b"),
                        new MyPattern("*,b")
                ),
                new MyPath("a/b"));
        assertEquals("a,b", result);
    }

    @Test
    public void testMatch_complexRankWildcardMatch() {
        String result = PatternMatcher.match(
                Arrays.asList(
                        new MyPattern("a,*,c,d,*,f"),
                        new MyPattern("a,*,c,d,e,*"),
                        new MyPattern("a,*,c,*,e,f")
                ),
                new MyPath("a/b/c/d/e/f"));
        assertEquals("a,*,c,d,e,*", result);
    }

    @Test(expected = IllegalStateException.class)
    public void testMatch_identicalPatternMatch() {
        String result = PatternMatcher.match(
                Arrays.asList(
                        new MyPattern("a,b"),
                        new MyPattern("a,b")
                ),
                new MyPath("a/b"));
    }
}