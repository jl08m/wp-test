package com.jli.wp.patternmatch;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jia on 4/23/2017.
 */
public class MyPattern {

    String DELIMITER = ",";
    public static String WILDCARD = "*";
    private List<String> tokens;
    private int tokenSize;  //since we ask for this frequently, slightly better than pulling array size?
    private int numberOfWildcards;
    private String pattern;

    public MyPattern(String pattern) {
        this.pattern = pattern;
        tokens = Arrays.asList(pattern.split(DELIMITER));
        tokenSize = tokens.size();
        numberOfWildcards = StringUtils.countMatches(pattern, WILDCARD);
    }

    public List<String> getTokens() {
        return tokens;
    }

    public String getPattern() {
        return pattern;
    }

    public int getTokenSize() {
        return tokenSize;
    }

    public int getNumberOfWildcards() {
        return numberOfWildcards;
    }
}
