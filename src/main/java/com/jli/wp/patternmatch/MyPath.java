package com.jli.wp.patternmatch;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jia on 4/23/2017.
 */
public class MyPath {

    String DELIMITER = "/";
    private String path;
    private List<String> tokens;
    private int tokenSize;

    public MyPath(String path) {
        this.path = path;
        tokens = Arrays.asList(path.split(DELIMITER));
        tokenSize = tokens.size();
    }

    public String getPath() {
        return path;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public int getTokenSize() {
        return tokenSize;
    }
}
